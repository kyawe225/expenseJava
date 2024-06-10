/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.configuration;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.BL.AuthBL;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

import jakarta.activation.DataSource;

/**
 *
 * @author kyaw zin htet
 */
@Configuration
public class SecurityConfiguration {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity security) throws Exception {
        var http = security.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(p -> p.requestMatchers("/login").anonymous().requestMatchers("/register")
                        .anonymous().requestMatchers("/swagger-ui/*").anonymous().requestMatchers("/v3/**").anonymous()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    protected AuthenticationManager globalConfig(HttpSecurity http,PasswordEncoder encoder , AuthBL bl) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .userDetailsService(bl)
                .passwordEncoder(encoder);
        return authenticationManagerBuilder.build();
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder password() {
        return new BCryptPasswordEncoder(10);
    }
}
