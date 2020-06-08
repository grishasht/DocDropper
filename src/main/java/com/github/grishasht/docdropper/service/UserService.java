package com.github.grishasht.docdropper.service;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import com.github.grishasht.docdropper.controller.exception.InvalidUserDataException;
import com.github.grishasht.docdropper.model.User;
import com.github.grishasht.docdropper.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final static Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private final static String PATTERN_EMAIL = "\\S{4,25}@\\w{1,10}.\\w{1,4}";
    private final static String PATTERN_LOGIN = "\\S{4,20}";
    private final static String PATTERN_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$";

    private static final String ERROR_MESSAGE_INVALID_EMAIL = "Entered email is invalid!\n";
    private static final String ERROR_MESSAGE_INVALID_LOGIN = "Entered login is invalid! " +
            "Must consist of non-whitespace characters and at least 4 chars.\n";
    private static final String ERROR_MESSAGE_INVALID_PASSWORD = "Entered password is invalid! " +
            "Must contain at least 1 uppercase, 1 lowercase and 1 digit chars. Minimum length 6 chars.\n";

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Boolean validateEmail(String email) {
        return Pattern.matches(PATTERN_EMAIL, email);
    }

    public Boolean validateLogin(String login) {
        return Pattern.matches(PATTERN_LOGIN, login);
    }

    public Boolean validatePassword(String password) {
        return Pattern.matches(PATTERN_PASSWORD, password);
    }

    public Boolean validateUserData(User user) {

        final StringBuilder errorMessage = new StringBuilder();

        final String userEmail = user.getEmail();
        final boolean isEmailValid = validateEmail(userEmail);

        if (!isEmailValid) {
            LOGGER.log(Level.SEVERE, "Invalid user input email: {}", userEmail);

            errorMessage.append(ERROR_MESSAGE_INVALID_EMAIL);
        }

        final String userLogin = user.getLogin();
        final Boolean isLoginValid = validateLogin(userLogin);

        if (!isLoginValid){
            LOGGER.log(Level.SEVERE, "Invalid user input login: {}", userLogin);

            errorMessage.append(ERROR_MESSAGE_INVALID_LOGIN);
        }

        final String userPassword = user.getPassword();
        final Boolean isPasswordValid = validatePassword(userPassword);

        if (!isPasswordValid) {
            LOGGER.log(Level.SEVERE, "Invalid user input password: {}", userPassword);

            errorMessage.append(ERROR_MESSAGE_INVALID_PASSWORD);
        }

        if (errorMessage.length() == 1) {
            throw new InvalidUserDataException(errorMessage.toString().replace("\n", ""));
        } else if (errorMessage.length() > 1) {
            throw new InvalidUserDataException(errorMessage.toString());
        }

        return true;
    }

    public User createUser(User user) {

        final UUID newUserGuid = UUID.randomUUID();

        final User newUser = new User()
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .setGuid(newUserGuid)
                .setLogin(user.getLogin())
                .setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(newUser);

        return newUser;
    }

    public User getUserInfo(UUID guid) {

        return userRepository.getUserByGuidNoPassword(guid);
    }

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public User updateUserByGuid(User newUserInfo, UUID userGuid) {
        final Integer userIdByGuid = userRepository.getUserByGuid(userGuid).getId();

        final User newUser = new User()
                .setId(userIdByGuid)
                .setGuid(userGuid)
                .setName(newUserInfo.getName())
                .setSurname(newUserInfo.getSurname())
                .setLogin(newUserInfo.getLogin())
                .setPassword(bCryptPasswordEncoder.encode(newUserInfo.getPassword()))
                .setEmail(newUserInfo.getEmail());

        userRepository.save(newUser);

        return newUser;
    }

    public User removeUserByGuid(UUID guid) {
        final User userToBeRemoved = userRepository.getUserByGuid(guid);

        userRepository.removeUserByGuid(guid);

        return userToBeRemoved;
    }
}
