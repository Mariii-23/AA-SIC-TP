package com.example.backend.controllers;

import com.example.backend.dto.userDTOs.AdminDTO;
import com.example.backend.dto.userDTOs.CustomerDTO;
import com.example.backend.exception.UserNotFoundException;
import com.example.backend.dto.userDTOs.CreateAdminDTO;
import com.example.backend.dto.userDTOs.ChangePasswordDTO;
import com.example.backend.dto.*;
import com.example.backend.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/customer")
    public CustomerDTO getCustomerbyId(final @RequestParam int id) {
        try {
            return userService.getCustomerById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/customer/all")
    public EnvelopeDTO<CustomerDTO> getAllCustomers(final @RequestParam int offset, final@RequestParam int numItems) {
        //final @RequestBody PaginationDTO paginationDTO
        return userService.getAllCustomers(offset, numItems);
    }

    @GetMapping("/numberOfCustomers")
    public int getNumberOfCustomers() {
        return userService.getNumberOfCustomers();
    }

    @GetMapping("")
    public AdminDTO getAdminById(final @RequestParam int id) {
        try {
            return userService.getAdminById(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/all")
    public EnvelopeDTO<AdminDTO> getAllAdmins(final @RequestParam int offset, final@RequestParam int numItems) {
        //final @RequestBody PaginationDTO paginationDTO
        return userService.getAllAdmins(offset, numItems);
    }

    @GetMapping("/numberOfAdmins")
    public int getNumberOfAdmins() {
        return userService.getNumberOfAdmins();
    }


    @PostMapping("/add")
    public AdminDTO addAdmin(final @RequestBody CreateAdminDTO admin) {
        return userService.addAdminDTO(admin);
    }

    @DeleteMapping("/remove/{id}")
    public void removeAdmin(@PathVariable int id) {
        try {
            userService.removeAdmin(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/edit/{admin_id}")
    public void editAdmin(final @PathVariable int admin_id, final @RequestBody CreateAdminDTO adminDTO) {
        try {
            userService.editAdmin(admin_id, adminDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/password/recover/{admin_id}")
    public String recoverPassword(final @PathVariable int admin_id) {
        try {
            return userService.recoverPassword(admin_id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/password/recover/confirm/{admin_id}")
    public boolean confirmRecoverPassword(final @PathVariable int admin_id, final @RequestBody ChangePasswordDTO changePasswordDTO) {
        try {
            return userService.confirmRecoverPassword(admin_id, changePasswordDTO.getToken(), changePasswordDTO.getNewPassword());
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
