package com.example.backend.dto.userDTOs;

import com.example.backend.model.User;

public class CreateUserDTO {
    private String email;
    private String password;
    private String name;

    public CreateUserDTO() {

    }

    public CreateUserDTO(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public CreateUserDTO(User user){
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
