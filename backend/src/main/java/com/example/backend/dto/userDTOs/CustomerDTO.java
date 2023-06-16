package com.example.backend.dto.userDTOs;

import com.example.backend.model.Customer;

import java.util.Date;

public class CustomerDTO extends UserDTO{
    private Date bitrhDate;
    private String address;
    private String nif;

    public CustomerDTO(Date bitrhDate, String address, String nif) {
        this.bitrhDate = bitrhDate;
        this.address = address;
        this.nif = nif;
    }

    public CustomerDTO(String email, String name, Date bitrhDate, String address, String nif, int id) {
        super(email, name, id);
        this.bitrhDate = bitrhDate;
        this.address = address;
        this.nif = nif;
    }

    public CustomerDTO(Customer customer) {
        super(customer);
        this.bitrhDate = customer.getBirthday();
        this.address = customer.getAddress();
        this.nif = customer.getNif();
    }

    public Date getBitrhDate() {
        return bitrhDate;
    }

    public void setBitrhDate(Date bitrhDate) {
        this.bitrhDate = bitrhDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
}
