package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // INCOME or EXPENSE

    // ===== Constructors =====
    public Category() {
    }

    public Category(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
