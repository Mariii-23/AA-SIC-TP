package com.example.backend.controllers;

import com.example.backend.dto.AdminDTO;
import com.example.backend.dto.CustomerDTO;
import com.example.backend.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomerbyId(@PathVariable int id) {
        return userService.getCustomerById(id);
    }

    @GetMapping("/customer/all")
    public List<CustomerDTO> getAllCustumers() {
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


    @PostMapping("/admin")
    public void addAdmin(final @RequestBody AdminDTO admin) {
        userService.addAdminDTO(admin);
    }

    @DeleteMapping("/admin/remove/{id}")
    public void removeAdmin(@PathVariable int id) {userService.removeAdmin(id);}


    @PostMapping("/admin/edit/{admin_id}")
    public void editAdmin(final @PathVariable int admin_id, final @RequestBody AdminDTO adminDTO) {
        userService.editAdmin(admin_id, adminDTO);
    }
}
