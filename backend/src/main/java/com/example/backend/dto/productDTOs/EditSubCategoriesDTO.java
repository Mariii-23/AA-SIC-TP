package com.example.backend.dto.productDTOs;

import java.util.HashMap;

public class EditSubCategoriesDTO {

    private HashMap<Integer,EditCategoryDTO> subCategories;

    public EditSubCategoriesDTO() {

    }

    public EditSubCategoriesDTO(HashMap<Integer, EditCategoryDTO> subCategories) {
        this.subCategories = subCategories;
    }

    public HashMap<Integer, EditCategoryDTO> getSubCategories() {
        return subCategories;
    }

}
