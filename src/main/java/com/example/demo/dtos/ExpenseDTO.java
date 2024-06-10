/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dtos;

import com.example.demo.models.Expenses;
import java.time.LocalDateTime;

/**
 *
 * @author kyaw zin htet
 */
public class ExpenseDTO {
    public String id;
    public String price;
    public String title;
    public String user_id;
    public String description;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;
    
    public ExpenseDTO(){
        
    }
    
    public ExpenseDTO(Expenses e){
        id = e.getId();
        price = e.getPrice();
        title=e.getTitle();
        user_id = e.getUser_id();
        description = e.getDescription();
        this.created_at = LocalDateTime.of(e.getCreated_at().toLocalDate(), e.getCreated_at().toLocalTime());
        this.updated_at = LocalDateTime.of(e.getCreated_at().toLocalDate(), e.getCreated_at().toLocalTime());
    }
}

