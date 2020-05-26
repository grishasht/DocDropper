package com.github.grishasht.docdropper.service;

import java.util.Collections;

import com.github.grishasht.docdropper.model.IUser;
import com.github.grishasht.docdropper.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService
{

    private final IUserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(IUserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
    {

        final IUser user = userRepository.getUserByLogin(login);

        if (user == null)
        {
            throw new UsernameNotFoundException(login);
        }

        return new User(user.getLogin(), user.getPassword(), Collections.emptyList());
    }
}