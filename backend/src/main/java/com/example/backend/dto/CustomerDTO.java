package com.example.backend.dto;

import com.example.backend.model.Customer;
import com.example.backend.model.ShoppingCart;

import java.util.Date;

public class CustomerDTO extends UserDTO{

    private Date birthday;
    private String nif;
    private String address;
    public CustomerDTO() {
        super();
    }

    public CustomerDTO(Date birthday, String nif, String address) {
        this.birthday = birthday;
        this.nif = nif;
        this.address = address;
    }

    public CustomerDTO(Date birthday, String nif, String address, String email, String password, String name) {
        super(email, password, name);
        this.birthday = birthday;
        this.nif = nif;
        this.address = address;
    }

    public CustomerDTO(Customer customer){
        super(customer);
        this.birthday = customer.getBirthday();
        this.nif = customer.getNif();
        this.address = customer.getAddress();
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getNif() {
        return this.nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
