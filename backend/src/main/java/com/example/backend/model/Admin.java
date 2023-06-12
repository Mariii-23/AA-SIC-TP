package com.example.backend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends User {
    public Admin() {
        super();
    }

    public Admin(String email, String password, String name) {
        super(email, password, name);
        super.setRole(Role.ADMIN);
    }
}