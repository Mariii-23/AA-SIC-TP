package com.example.backend.controllers;

import com.example.backend.dto.orderDTOs.ShoppingCartDTO;
import com.example.backend.dto.productDTOs.ProductSimpleDTO;
import com.example.backend.dto.userDTOs.*;
import com.example.backend.exception.UserNotFoundException;
import com.example.backend.dto.*;
import com.example.backend.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/favourites")
     public EnvelopeDTO<ProductSimpleDTO> getFavourites(final @RequestParam int id, final @RequestParam int offset, final @RequestParam int numItems) {
        try {
            return userService.getFavourites(id, offset, numItems);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/numberOfFavourites")
    public int getNumberOfFavourites(final @RequestParam int id) {
        try {
            return userService.getNumberOfFavourites(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("")
    public CustomerDTO getCustomerbyId(final @RequestParam int id) {
        try {
            return userService.getCustomerById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @PostMapping("/edit")
    public void editCustomer(final @RequestParam int customer_id, final @RequestBody CreateCustomerDTO customerDTO) {
        try {
            userService.editCustomer(customer_id, customerDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/favourite/add")
    public void addFavourite(final @RequestBody AddRemoveFavouriteDTO favourite) {
        try {
            userService.addFavourite(favourite.getCustomerId(), favourite.getProductId());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/favourite/delete")
    public void deleteFavourite(final @RequestBody AddRemoveFavouriteDTO favourite) {
        try {
            userService.deleteFavourite(favourite.getCustomerId(), favourite.getProductId());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/password/recover")
    public int recoverPassword(final @RequestParam String email) {
        try {
            return userService.recoverPassword(email);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/password/recover/confirm/{customer_id}")
    public boolean confirmRecoverPassword(final @PathVariable int customer_id, final @RequestBody ChangePasswordDTO changePasswordDTO) {
        try {
            return userService.confirmRecoverPassword(customer_id, changePasswordDTO.getToken(), changePasswordDTO.getNewPassword());
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
