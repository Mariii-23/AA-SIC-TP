package com.example.backend.dto;

import com.example.backend.model.Admin;

public class AdminDTO extends UserDTO {
    public AdminDTO() {
        super();
    }

    public AdminDTO(String email, String name, int id) {
        super(email, name, id);
    }

    public AdminDTO(Admin admin) {
        super(admin);
    }
}
