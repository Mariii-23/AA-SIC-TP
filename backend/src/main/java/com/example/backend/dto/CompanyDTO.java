package com.example.backend.dto;

import com.example.backend.model.Company;

import java.util.List;

public class CompanyDTO {
    private String name;
    private String email;
    private String contact;
    private String address;
    private String postCode;
    private String schedule;

    public CompanyDTO() {
    }

    public CompanyDTO(String name, String email, String contact, String address, String postCode, String schedule) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.postCode = postCode;
        this.schedule = schedule;
    }

    public CompanyDTO(Company company) {
    	this.name = company.getName();
        this.email = company.getEmail();
        this.contact = company.getContact();
        this.address = company.getAddress();
        this.postCode = company.getPostCode();
        this.schedule = company.getSchedule();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSchedule() {
        return this.schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
