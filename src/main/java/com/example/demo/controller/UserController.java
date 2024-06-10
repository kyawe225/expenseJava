/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.BL.UserBL;
import com.example.demo.dtos.UserCreateDTO;
import com.example.demo.dtos.UserDTO;
import com.example.demo.models.common.ResponseModel;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author kyaw zin htet
 */
@RestController
@RequestMapping(path="user",produces = MediaType.APPLICATION_JSON_VALUE)
@SecurityRequirement(name = "basicAuth")
public class UserController {
    @Autowired
    private UserBL userbl;
    public UserController(){
        
    }
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseModel<List<UserDTO>> Index(){
        var result = userbl.GetAllUsers();
        var returnResult = new ResponseModel<List<UserDTO>>().setStatus("Success").setModel(result).setMessage("Successfully fetched user");
        return returnResult;
    }
    //#region start
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseModel<UserCreateDTO> Create(@RequestBody UserCreateDTO model){
        var result = userbl.InsertUser(model);
        var returnResult = new ResponseModel<UserCreateDTO>().setStatus("Success").setModel(result).setMessage("Successfully fetched user");
        return returnResult;
    }
    //#endregion
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseModel<UserCreateDTO> Update(String id,@RequestBody UserCreateDTO model){
        var result = userbl.UpdateUser(id, model);
        var returnResult = new ResponseModel<UserCreateDTO>().setStatus("Success").setModel(result).setMessage("Successfully fetched user");
        return returnResult;
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseModel<String> Delete(String id){
        userbl.DeleteUser(id);
        var returnResult = new ResponseModel<String>().setStatus("Success").setModel("Deleted Successfully").setMessage("Successfully fetched user");
        return returnResult;
    }
}
