package com.example.backend.controllers;

import com.example.backend.dto.AdminDTO;
import com.example.backend.dto.ChangePasswordDTO;
import com.example.backend.dto.CustomerDTO;
import com.example.backend.services.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource(name = "userService")
    private UserService userService;
    @Autowired
    private WebClient emailVerifier;

    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomerbyId(@PathVariable int id) {
        return userService.getCustomerById(id);
    }

    @GetMapping("/customer/all")
    public List<CustomerDTO> getAllCustumers() {
        return userService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public AdminDTO getAdminbyId(@PathVariable int id) {
        return userService.getAdminById(id);
    }

    @GetMapping("/all")
    public List<AdminDTO> getAllAdmins() {
        return userService.getAllAdmins();
    }


    @PostMapping("/add")
    public void addAdmin(final @RequestBody AdminDTO admin) {
        boolean valid = emailVerifier
                .post()
                .bodyValue("email=" + admin.getEmail())
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(jsonNode -> jsonNode.get("valid").asBoolean())
                .block();
        if (valid) userService.addAdminDTO(admin);
    }

    @DeleteMapping("/remove/{id}")
    public void removeAdmin(@PathVariable int id) {userService.removeAdmin(id);}


    @PostMapping("/edit/{admin_id}")
    public void editAdmin(final @PathVariable int admin_id, final @RequestBody AdminDTO adminDTO) {
        userService.editAdmin(admin_id, adminDTO);
    }

    @PostMapping("/password/recover/{admin_id}")
    public String recoverPassword(final @PathVariable int admin_id) {
        return userService.recoverPassword(admin_id);
    }

    @PostMapping("/password/recover/confirm/{admin_id}")
    public boolean confirmRecoverPassword(final @PathVariable int admin_id, final @RequestBody ChangePasswordDTO changePasswordDTO) {
        return userService.confirmRecoverPassword(admin_id, changePasswordDTO.getToken(), changePasswordDTO.getNewPassword());
    }
}
