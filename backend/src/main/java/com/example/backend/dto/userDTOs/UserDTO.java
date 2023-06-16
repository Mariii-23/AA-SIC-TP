package com.example.backend.dto.userDTOs;

import com.example.backend.model.User;

public class UserDTO {

    private int iD;
    private String email;
    private String name;

    public UserDTO() {

    }

    public UserDTO(String email, String name, int iD) {
        this.iD = iD;
        this.email = email;
        this.name = name;
    }

    public UserDTO(User user){
        this.iD = user.getiD();
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
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }
}
