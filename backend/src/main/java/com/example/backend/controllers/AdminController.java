package com.example.backend.controllers;

import com.example.backend.dto.*;
import com.example.backend.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
    public EnvelopeDTO<CustomerDTO> getAllCustomers(final @RequestBody PaginationDTO paginationDTO) {
        return userService.getAllCustomers(paginationDTO.getOffset(), paginationDTO.getNumItems());
    }

    @GetMapping("/numberOfCustomers")
    public int getNumberOfCustomers() {
        return userService.getNumberOfCustomers();
    }

    @GetMapping("/{id}")
    public AdminDTO getAdminbyId(@PathVariable int id) {
        return userService.getAdminById(id);
    }

    @GetMapping("/all")
    public EnvelopeDTO<AdminDTO> getAllAdmins(final @RequestBody PaginationDTO paginationDTO) {
        return userService.getAllAdmins(paginationDTO.getOffset(), paginationDTO.getNumItems());
    }

    @GetMapping("/numberOfAdmins")
    public int getNumberOfAdmins() {
        return userService.getNumberOfAdmins();
    }


    @PostMapping("/add")
    public void addAdmin(final @RequestBody AdminDTO admin) {
        userService.addAdminDTO(admin);
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
