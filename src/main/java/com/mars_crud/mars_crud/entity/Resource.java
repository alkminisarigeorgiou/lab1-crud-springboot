package com.mars_crud.mars_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Resource {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private int quantity;

  private String description;

    //Default Constructor.
    public Resource() {
    }

    //Core Constructor.
    public Resource(int id, String name, int quantity, String description) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.description = description;
    }

    // Getters and Setters.
    public int getId() {
    return id;
    }

    public void setId(int id) {
    this.id = id;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public int getQuantity() {
    return quantity;
    }

    public void setQuantity(int quantity) {
    this.quantity = quantity;
    }

    public String getDescription() {
    return description;
    }

    public void setDescription(String description) {
    this.description = description;
    }
}

