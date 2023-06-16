package com.example.backend.dto.productDTOs;

public class EditMaterialDTO extends MaterialDTO{
    private byte[] image;

    public EditMaterialDTO() {
    }

    public EditMaterialDTO(int id, String name, byte[] image) {
        super(id, name);
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImages(byte[] image) {
        this.image = image;
    }
}
