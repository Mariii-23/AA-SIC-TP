package com.example.backend.dto;

import com.example.backend.model.User;

public class UserDTO {
    private String email;
    private String name;

    public UserDTO() {

    }

    public UserDTO(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public UserDTO(User user){
        this.email = user.getEmail();
        this.name = user.getName();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
