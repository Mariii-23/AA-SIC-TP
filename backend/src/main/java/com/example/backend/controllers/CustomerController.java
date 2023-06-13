package com.example.backend.controllers;

import com.example.backend.Exception.UserNotFoundException;
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

    @GetMapping("/{id}/favourites")
     public EnvelopeDTO<FavouriteDTO> getFavourites(@PathVariable int id, final @RequestBody PaginationDTO paginationDTO) {
        try {
            return userService.getFavourites(id, paginationDTO.getOffset(), paginationDTO.getNumItems());
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}/numberOfFavourites")
    public int getNumberOfFavourites(@PathVariable int id) {
        try {
            return userService.getNumberOfFavourites(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/cart/{id}")
    public ShoppingCartDTO getShoppingCart(@PathVariable int id) {
        try {
            return userService.getShoppingCart(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{id}/orders")
    public EnvelopeDTO<OrderSimpleDTO> getOrders(@PathVariable int id, final @RequestBody PaginationDTO paginationDTO) {
        try {
            return userService.getOrders(id, paginationDTO.getOffset(), paginationDTO.getNumItems());
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{id}/numberOfOrders")
    public int getNumberOfOrders(@PathVariable int id) {
        try {
            return userService.getNumberOfOrders(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @PostMapping("/edit/{customer_id}")
    public void editCustomer(final @PathVariable int customer_id, final @RequestBody CustomerDTO costumerDTO) {
        try {
            userService.editCustomer(customer_id, costumerDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/favourite/add")
    public void addFavourite(final @RequestBody AddRemoveFavouriteDTO favourite) {
        try {
            userService.addFavourite(favourite.getCostumerId(), favourite.getProductId());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/favourite/delete")
    public void deleteFavourite(final @RequestBody AddRemoveFavouriteDTO favourite) {
        try {
            userService.deleteFavourite(favourite.getCostumerId(), favourite.getProductId());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/password/recover/{customer_id}")
    public String recoverPassword(final @PathVariable int customer_id) {
        try {
            return userService.recoverPassword(customer_id);
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
