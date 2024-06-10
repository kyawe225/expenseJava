/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dtos;

import java.time.LocalDateTime;
import com.example.demo.models.User;

/**
 *
 * @author kyaw zin htet
 */
public class UserDTO {

    public String id;
    public String name;
    public String email;
    public String password;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;

    public UserDTO() {

    }

    /**
     *
     * @param name
     * @param email
     * @param password
     * @param created_at
     * @param updated_at
     */
    public UserDTO(String Id, String name, String email, String password, LocalDateTime created_at, LocalDateTime updated_at) {
        id = Id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.created_at = LocalDateTime.of(created_at.toLocalDate(), created_at.toLocalTime());
        this.updated_at = LocalDateTime.of(updated_at.toLocalDate(), updated_at.toLocalTime());
    }

    public UserDTO(User user) {
        id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.created_at = LocalDateTime.of(user.getCreated_at().toLocalDate(), user.getCreated_at().toLocalTime());
        this.updated_at = LocalDateTime.of(user.getCreated_at().toLocalDate(), user.getCreated_at().toLocalTime());
    }
}
