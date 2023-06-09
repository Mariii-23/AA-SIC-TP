package com.example.backend.controllers;

import com.example.backend.dto.AdminDTO;
import com.example.backend.dto.CustomerDTO;
import com.example.backend.model.Admin;
import com.example.backend.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomerbyId(int id) {
        return userService.getCustomerById(id);
    }

    @GetMapping("/customer/all")
    public List<CustomerDTO> getAllCostumers() {
        return userService.getAllCustomers();
    }

    @GetMapping("/admin/{id}")
    public AdminDTO getAdminbyId(@PathVariable int id) {
        return userService.getAdminById(id);
    }

    @GetMapping("/admin/all")
    public List<AdminDTO> getAllAdmins() {
        return userService.getAllAdmins();
    }

    @PostMapping("/customer")
    public void addCustomer(final @RequestBody CustomerDTO costumer) {
        userService.addCustomerDTO(costumer);
    }


    @PostMapping("/admin")
    public void addAdmin(final @RequestBody AdminDTO admin){
        userService.addAdminDTO(admin);
    }
}
