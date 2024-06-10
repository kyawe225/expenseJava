/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.BL;

/**
 *
 * @author kyaw zin htet
 */
import com.example.demo.dtos.ExpenseCreateDTO;
import com.example.demo.dtos.ExpenseDTO;
import com.example.demo.models.Expenses;
import com.example.demo.repositories.ExpenseRepository;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseBL {
    @Autowired
    public ExpenseRepository repository;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserBL.class);

    public List<ExpenseDTO> GetAllUsers() {
        List<ExpenseDTO> d = new ArrayList<>();
        repository.findAll().forEach(p -> {
            ExpenseDTO dto = new ExpenseDTO(p);
            d.add(dto);
        });
        return d;
    }

    public ExpenseCreateDTO Insert(ExpenseCreateDTO model) {
        Expenses expense = new Expenses();
        expense.setPrice(model.price);
        expense.setDescription(model.description);
        expense.setCreated_at(LocalDateTime.now(ZoneOffset.UTC));
        expense.setUpdated_at(LocalDateTime.now(ZoneOffset.UTC));
        expense.setTitle(model.title);
        expense.setUser_id(model.user_id);
        expense.setId("exp" + UUID.randomUUID().toString());
        var r = repository.save(expense);
        if (r == null) {
            return null;
        }
        return model;
    }

    public ExpenseCreateDTO Update(String Id, ExpenseCreateDTO model) {
        Optional<Expenses> temp = repository.findById(Id);
        if(temp.isEmpty()) {logger.error("Not Found");return null;}
        Expenses expense = temp.get();
        expense.setPrice(model.price);
        expense.setDescription(model.description);
        expense.setTitle(model.title);
        var r = repository.save(expense);
        if (r == null) {
            return null;
        }
        return model;
    }
    
    public boolean Delete(String Id) {
        Optional<Expenses> temp = repository.findById(Id);
        if (temp.isEmpty()) {logger.error("Not Found");return false;}
        Expenses user = temp.get();
        repository.delete(user);
        return true;
    }
}
