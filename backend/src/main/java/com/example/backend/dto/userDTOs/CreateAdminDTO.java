package com.example.backend.dto.userDTOs;

import com.example.backend.model.Admin;

public class CreateAdminDTO extends CreateUserDTO {

    public CreateAdminDTO() {
        super();
    }

    public CreateAdminDTO(String email, String password, String name) {
        super(email, password, name);
    }
    public CreateAdminDTO(Admin admin){
        super(admin);
    }

}
