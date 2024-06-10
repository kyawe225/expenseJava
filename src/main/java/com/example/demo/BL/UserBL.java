/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BL;

import com.example.demo.dtos.UserCreateDTO;
import com.example.demo.dtos.UserDTO;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kyaw zin htet
 */
@Repository
public class UserBL {

    @Autowired
    public UserRepository repository;
    @Autowired
    public PasswordEncoder encoder;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserBL.class);

    public List<UserDTO> GetAllUsers() {
        List<UserDTO> d = new ArrayList<>();
        repository.findAll().forEach(p -> {
            UserDTO dto = new UserDTO(p);
            d.add(dto);
        });
        return d;
    }

    public UserCreateDTO InsertUser(UserCreateDTO model) {
        User user = new User();
        user.setEmail(model.email);
        user.setName(model.name);
        user.setCreated_at(LocalDateTime.now(ZoneOffset.UTC));
        user.setUpdated_at(LocalDateTime.now(ZoneOffset.UTC));
        user.setPassword(encoder.encode(model.password));
        user.setId("usr" + UUID.randomUUID().toString());
        var r = repository.save(user);
        if (r == null) {
            logger.error("data type not same");
            return null;
        }
        return model;
    }

    public UserCreateDTO UpdateUser(String Id, UserCreateDTO model) {
        Optional<User> temp = repository.findById(Id);
        if (temp.isEmpty()) {
            logger.error("Not found");
            return null;
        }
        User user = temp.get();
        user.setEmail(model.email);
        user.setName(model.name);
        user.setUpdated_at(LocalDateTime.now(ZoneOffset.UTC));
        user.setPassword(encoder.encode(model.password));
        var r = repository.save(user);
        if (r == null) {
            
            return null;
        }
        return model;
    }

    public boolean DeleteUser(String Id) {
        Optional<User> temp = repository.findById(Id);
        if (temp.isEmpty()){
            logger.error("Not found");
            return false;
        }
        User user = temp.get();
        repository.delete(user);
        return true;
    }
}
