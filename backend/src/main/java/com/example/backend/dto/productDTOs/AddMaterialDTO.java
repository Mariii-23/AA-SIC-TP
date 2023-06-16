package com.example.backend.dto.productDTOs;

import org.springframework.web.multipart.MultipartFile;

public class AddMaterialDTO {
    private String name;
    private MultipartFile image;

    public AddMaterialDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
