package com.example.backend.services;

import com.example.backend.dto.AdminDTO;
import com.example.backend.dto.CustomerDTO;
import com.example.backend.model.Admin;
import com.example.backend.model.Customer;
import com.example.backend.repositories.AdminRep;
import com.example.backend.repositories.CustomerRep;
import com.example.backend.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    private UserRep userRep;
    @Autowired
    private CustomerRep customerRep;
    @Autowired
    private AdminRep adminRep;


    public Customer addCustomer(Customer customer) {
        return customerRep.save(customer);
    }

    public Admin addAdmin(Admin admin) {
        return adminRep.save(admin);
    }

    public CustomerDTO getCustomerById(int id) {
        Customer customer = customerRep.findById(id).orElse(null);
        return new CustomerDTO(customer);
    }

    public AdminDTO getAdminById(int id) {
        Admin admin = adminRep.findById(id).orElse(null);
        return new AdminDTO(admin);
    }

    public List<AdminDTO> getAllAdmins() {
        List<AdminDTO> result = new ArrayList<>();
        List<Admin> admins = adminRep.findAll();
        admins.forEach(admin -> {
            result.add(new AdminDTO(admin));
        });
        return result;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> result = new ArrayList<>();
        List<Customer> customers = customerRep.findAll();
        customers.forEach(customer -> {
            result.add(new CustomerDTO(customer));
        });
        return result;
    }

    public void addCustomerDTO(CustomerDTO costumerDTO){
        Customer customer = new Customer(costumerDTO.getBirthday(),
                                         costumerDTO.getNif(),
                                         costumerDTO.getAddress(),
                                         costumerDTO.getEmail(),
                                         costumerDTO.getPassword(),
                                         costumerDTO.getName());
        addCustomer(customer);
    }

    public void addAdminDTO(AdminDTO adminDTO){
        Admin admin = new Admin(adminDTO.getEmail(),
                                adminDTO.getName(),
                                adminDTO.getPassword());
        addAdmin(admin);
    }
}
