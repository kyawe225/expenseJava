/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author kyaw zin htet
 */
@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    private String id;
    @Column(columnDefinition = "price")
    private String price;
    @Column(columnDefinition = "title")
    private String title;
    @Column(columnDefinition = "user_id")
    private String user_id;
    @Column(columnDefinition = "description")
    private String description;
    @Column(columnDefinition = "created_at")
    private LocalDateTime created_at;
    @Column(columnDefinition = "updated_at")
    private LocalDateTime updated_at;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the user_id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the created_at
     */
    public LocalDateTime getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the updated_at
     */
    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
