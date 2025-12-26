package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) {
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password("{noop}password")
                .roles("USER")
                .build();
    }
}
