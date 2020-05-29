package com.spring.service;

import com.spring.dao.UserDetailsDao;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;

import org.springframework.security.core.userdetails.User.UserBuilder;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDetailsDao.findUserByName(s);
        UserBuilder builder = null;
        if (user.getUsername() != null) {
            builder = withUsername(user.getUsername());

            builder.password(user.getPassword());
            builder.roles(user.getRoles());
        }
        else{
            //exception
        }
        return builder.build();
    }
}
