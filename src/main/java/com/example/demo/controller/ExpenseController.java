/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.BL.ExpenseBL;
import com.example.demo.dtos.ExpenseCreateDTO;
import com.example.demo.dtos.ExpenseDTO;
import com.example.demo.models.common.ResponseModel;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping(value = "expense",produces = MediaType.APPLICATION_JSON_VALUE)
@SecurityRequirement(name = "basicAuth")
public class ExpenseController {
    @Autowired
    private ExpenseBL expensebl;
    private Logger log = LoggerFactory.getLogger(ExpenseController.class);
    public ExpenseController(){
        
    }
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseModel<List<ExpenseDTO>> Index(){
        var result = expensebl.GetAllUsers();
        var returnResult = new ResponseModel<List<ExpenseDTO>>().setStatus("Success").setModel(result).setMessage("Successfully fetched user");
        log.info("successfully fetch user");
        return returnResult;
    }
    
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseModel<ExpenseCreateDTO> Create(@RequestBody ExpenseCreateDTO model){
        var result = expensebl.Insert(model);
        var returnResult = new ResponseModel<ExpenseCreateDTO>().setStatus("Success").setModel(result).setMessage("Successfully fetched user");
        log.info("successfully add user");
        return returnResult;
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseModel<ExpenseCreateDTO> Update(String id,@RequestBody ExpenseCreateDTO model){
        var result = expensebl.Update(id, model);
        var returnResult = new ResponseModel<ExpenseCreateDTO>().setStatus("Success").setModel(result).setMessage("Successfully fetched user");
        log.info("updated successfully");
        return returnResult;
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseModel<String> Delete(String id){
        boolean i=expensebl.Delete(id);
        var returnResult = new ResponseModel<String>().setStatus("Success").setModel("Deleted Successfully").setMessage("Successfully fetched user");
        if(!i) returnResult.setStatus("Error").setMessage("Not Found").setModel("Bye");
        log.info("deleted successfully");
        return returnResult;
    }
}
