package com.example.sesiones._5_6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ordenadores")
public class Laptop {

    // Attribute

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String description;
    private LocalDate release;


    // Constructor

    public Laptop() {
    }

    public Laptop(Long id, String brand, String description, LocalDate release) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.release = release;
    }

    // Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }
}
