package com.example.backend.dto;

public class AddMaterialDTO {
    private String name;
    private byte[] image;

    public AddMaterialDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
