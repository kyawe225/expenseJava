/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repositories;

import com.example.demo.models.Expenses;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author kyaw zin htet
 */
public interface ExpenseRepository extends CrudRepository<Expenses, String> {
    
}
