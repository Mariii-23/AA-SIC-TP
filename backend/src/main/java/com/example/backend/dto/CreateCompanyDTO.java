package com.example.backend.dto;

public class CreateCompanyDTO extends CompanyDTO{
    private byte[] logoImage;

    public CreateCompanyDTO() {
        super();
    }

    public CreateCompanyDTO(String name, String email, String contact, String address, String postCode, String schedule, byte[] image) {
        super(name, email, contact, address, postCode, schedule);
        this.logoImage = image;
    }

    public byte[] getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(byte[] logoImage) {
        this.logoImage = logoImage;
    }
}
