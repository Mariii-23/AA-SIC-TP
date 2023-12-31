package com.example.backend.controllers;

import com.example.backend.dto.orderDTOs.*;
import com.example.backend.exception.ItemNotFoundException;
import com.example.backend.exception.OrderAlreadyPayedException;
import com.example.backend.exception.OrderNotFoundException;
import com.example.backend.exception.UserNotFoundException;
import com.example.backend.dto.*;
import com.example.backend.model.OrderState;
import com.example.backend.services.OrderService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource(name = "orderService")
    private OrderService orderService;

    @GetMapping("/customer/orders")
    public EnvelopeDTO<OrderSimpleDTO> getOrders(final @RequestParam int customerId, final @RequestParam int offset, final @RequestParam int numItems){
        try {
            return orderService.getOrdersOfCustomer(customerId, offset, numItems);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/customer/order")
    public OrderDetailedDTO getOrder(final @RequestParam int orderId){
        try {
            return orderService.getOrder(orderId);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/customer/numberOfOrders")
    public int getNumberOfCustomerOrders(final @RequestParam int id) {
        try {
            return orderService.getNumberOfCustomerOrders(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/admin/orders")
    public EnvelopeDTO<OrderSimpleDTO> getAllOrders(final @RequestParam int offset, final @RequestParam int numItems){
        return orderService.getAllOrders(offset, numItems);
    }

    @GetMapping("/admin/orders/pending")
    public EnvelopeDTO<OrderSimpleDTO> getPendingOrders(final @RequestParam int offset, final @RequestParam int numItems){
        return orderService.getPendingOrders(offset, numItems);
    }

    @GetMapping("/admin/orders/ready")
    public EnvelopeDTO<OrderSimpleDTO> getReadyOrders(final @RequestParam int offset, final @RequestParam int numItems){
        return orderService.getReadyOrders(offset, numItems);
    }

    @GetMapping("/admin/orders/done")
    public EnvelopeDTO<OrderSimpleDTO> getDoneOrders(final @RequestParam int offset, final @RequestParam int numItems){
        return orderService.getDoneOrders(offset, numItems);
    }

    @GetMapping("/admin/numberOfOrders")
    public int getNumberOfOrders() {
        return orderService.getNumberOfOrders();
    }

    @GetMapping("/admin/numberOfOrders/pending")
    public int getNumberOfPendingOrders() {
        return orderService.getNumberOfPendingOrders();
    }

    @GetMapping("/admin/numberOfOrders/ready")
    public int getNumberOfReadyOrders() {
        return orderService.getNumberOfReadyOrders();
    }

    @GetMapping("/admin/numberOfOrders/done")
    public int getNumberOfDoneOrders() {
        return orderService.getNumberOfDoneOrders();
    }

    @PostMapping("/admin/ready/{orderId}")
    public boolean setOrderReady(@PathVariable int orderId){
        try {
            return orderService.setOrderState(orderId, OrderState.READY);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/admin/done/{orderId}")
    public boolean setOrderDone(@PathVariable int orderId){
        try {
            return orderService.setOrderState(orderId, OrderState.DONE);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("customer/shoppingCart")
    public ShoppingCartDTO getShoppingCart(final @RequestParam int id) {
        try {
            return orderService.getShoppingCart(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/customer/create")
    public OrderDetailedDTO createOrder(final @RequestBody CreateOrderDTO order){
        try {
            return orderService.createOrder(order.getCustomerId() , order.getAddress(), order.isStorePickUp());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/customer/shoppingCart/product")
    public int addProductToShoppingCart(final @RequestBody AddProductToShoppingCartDTO product){
        try {
            return orderService.addProductToShoppingCart(product.getCustomerId(),
                                                  product.getProductId(),
                                                  product.getMaterialId(),
                                                  product.getQuantity());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/customer/shoppingCart/quantity")
    public void setProductQuantityInShoppingCart(final @RequestBody SetProductQuantityDTO product){
        try {
            orderService.setProductQuantity(product.getItemId(), product.getQuantity());
        } catch (ItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/customer/shoppingCart/product/{itemId}")
    public void deleteProductFromShoppingCart(@PathVariable int itemId){
        try {
            orderService.deleteItemFromShoppingCart(itemId);
        } catch (ItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("admin/payment/{orderId}")
    public boolean payOrder(@PathVariable int orderId){
        try {
            return orderService.payOrder(orderId);
        } catch (OrderNotFoundException | OrderAlreadyPayedException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
