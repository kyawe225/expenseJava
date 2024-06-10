package com.example.demo.models.common;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * dynamic class for resposne
 * @author kyaw zin htet
 */
public class ResponseModel<T> {
    public String status;
    public T model;
    public String message;
    
    public ResponseModel<T> setStatus(String status){
        this.status = status;
        return this;
    }
    
    public ResponseModel<T> setModel(T model){
        this.model = model;
        return this;
    }
    public ResponseModel<T> setMessage(String message){
        this.message=message;
        return this;
    }
}

