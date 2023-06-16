package com.example.backend.dto.productDTOs;

import com.example.backend.model.Material;

public class MaterialDTO {
    private int id;
    private String name;

    public MaterialDTO() {
    }

    public MaterialDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MaterialDTO(Material material){
        this.id = material.getID();
        this.name = material.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
