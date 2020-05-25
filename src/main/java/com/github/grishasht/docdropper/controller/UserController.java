package com.github.grishasht.docdropper.controller;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import com.github.grishasht.docdropper.controller.exception.InvalidUserDataException;
import com.github.grishasht.docdropper.model.IUser;
import com.github.grishasht.docdropper.model.impl.User;
import com.github.grishasht.docdropper.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    private final static Logger LOGGER = Logger.getLogger(UserController.class.getName());

    private static final String RESPONSE_FIELD_GUID = "guid";

    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/guest/sign-up")
    public String signUp(@RequestBody @Valid User requestUser) {

        if (!userService.validateUserData(requestUser)) {
            final String msg = "Invalid user credential data!";

            LOGGER.log(Level.SEVERE, msg);
            throw new InvalidUserDataException(msg);
        }

        final String requestUserLogin = requestUser.getLogin();

        String msg = String.format("User %s credential data is successfully validated", requestUserLogin);
        LOGGER.info(msg);

        final IUser newUser = userService.createUser(requestUser);

        msg = String.format("User %s info successfully created!", newUser.getLogin());
        LOGGER.info(msg);

        final JSONObject responseJson = getGuidJson(newUser);

        return responseJson.toString();
    }


    @GetMapping("/login")
    public String userLogin(@RequestBody User user){

        final String userLogin = user.getLogin();
        final IUser userByLogin = userService.getUserByLogin(userLogin);

        final String msg = String.format("User %s guild retrieved!", userLogin);
        LOGGER.info(msg);

        return getGuidJson(userByLogin).toString();
    }

    @GetMapping("/{userGuid}/personal")
    public IUser getAllUserInfo(@PathVariable UUID userGuid) {

        final IUser user = userService.getUserInfo(userGuid);

        final String msg = String.format("User %s info successfully retrieved from the database", user.getLogin());
        LOGGER.info(msg);

        return user;
    }

    @PutMapping("/{userGuid}/personal")
    public void updateUserInfo(@RequestBody @Valid User newUserInfo, @PathVariable UUID userGuid) {

        userService.updateUserByGuid(newUserInfo, userGuid);

        final String msg = String.format("User %s info successfully updated in the database", newUserInfo.getLogin());
        LOGGER.info(msg);
    }

    @DeleteMapping("/{userGuid}/personal")
    public void removeUser(@PathVariable UUID userGuid) {

        final IUser removedUser = userService.removeUserByGuid(userGuid);

        final String msg = String.format("User %s info successfully removed from the database", removedUser.getLogin());
        LOGGER.info(msg);

    }

    private JSONObject getGuidJson(IUser user) {
        final JSONObject responseJson = new JSONObject();

        responseJson.put(RESPONSE_FIELD_GUID, user.getGuid().toString());
        return responseJson;
    }
}
