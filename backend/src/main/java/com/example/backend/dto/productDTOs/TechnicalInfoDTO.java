package com.example.backend.dto.productDTOs;

import com.example.backend.model.TechnicalInfo;

public class TechnicalInfoDTO {
    private String name;
    private String description;

    public TechnicalInfoDTO() {
    }

    public TechnicalInfoDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public TechnicalInfoDTO(TechnicalInfo technicalInfo) {
        this.name = technicalInfo.getName();
        this.description = technicalInfo.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
