package com.example.backend.dto.userDTOs;

import com.example.backend.model.Customer;

import java.util.Date;

public class CreateCustomerDTO extends CreateUserDTO {

    private Date birthday;
    private String nif;
    private String address;
    public CreateCustomerDTO() {
        super();
    }

    public CreateCustomerDTO(Date birthday, String nif, String address) {
        this.birthday = birthday;
        this.nif = nif;
        this.address = address;
    }

    public CreateCustomerDTO(Date birthday, String nif, String address, String email, String password, String name) {
        super(email,password, name);
        this.birthday = birthday;
        this.nif = nif;
        this.address = address;
    }

    public CreateCustomerDTO(Customer customer){
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
