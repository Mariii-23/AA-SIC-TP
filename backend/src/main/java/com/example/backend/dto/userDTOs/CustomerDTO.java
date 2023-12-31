package com.example.backend.dto.userDTOs;

import com.example.backend.model.Customer;

import java.time.LocalDate;
import java.util.Date;

public class CustomerDTO extends UserDTO{
    private LocalDate bitrhDate;
    private String address;
    private String nif;

    public CustomerDTO(LocalDate bitrhDate, String address, String nif) {
        this.bitrhDate = bitrhDate;
        this.address = address;
        this.nif = nif;
    }

    public CustomerDTO(String email, String name, LocalDate bitrhDate, String address, String nif, int id) {
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

    public LocalDate getBitrhDate() {
        return bitrhDate;
    }

    public void setBitrhDate(LocalDate bitrhDate) {
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
