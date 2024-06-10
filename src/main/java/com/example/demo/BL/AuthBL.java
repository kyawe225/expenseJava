package com.example.demo.BL;

import java.util.ArrayList;
import java.util.Collections;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.UserRepository;

@Service
public class AuthBL implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    private UserBL userBL;

    public AuthBL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) {
        var userFromDb = userRepository.findByName(s).getFirst();
                // .orElseThrow(() -> new UsernameNotFoundException("No user found with this email address."));
        ArrayList<GrantedAuthority> authorities = new java.util.ArrayList<>(Collections.emptyList());

        authorities.add((GrantedAuthority) ()-> "Admin");

        return new User(userFromDb.getName(), userFromDb.getPassword(), authorities);
    }
}
