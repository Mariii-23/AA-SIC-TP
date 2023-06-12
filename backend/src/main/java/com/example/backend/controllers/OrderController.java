package com.example.backend.controllers;

import com.example.backend.dto.*;
import com.example.backend.model.OrderState;
import com.example.backend.services.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource(name = "orderService")
    private OrderService orderService;

    @GetMapping("/customer/orders/{costumerId}")
    public List<OrderSimpleDTO> getOrders(@PathVariable int costumerId){
        return orderService.getOrdersOfCostumer(costumerId);
    }

    @GetMapping("/customer/order/{orderId}")
    public OrderDetailedDTO getOrder(@PathVariable int orderId){
        return orderService.getOrder(orderId);
    }

    @GetMapping("/admin/orders")
    public List<OrderSimpleDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/admin/ready/{orderId}")
    public boolean setOrderReady(@PathVariable int orderId){
        return orderService.setOrderState(orderId, OrderState.READY);
    }

    @PostMapping("/admin/done/{orderId}")
    public boolean setOrderDone(@PathVariable int orderId){
        return orderService.setOrderState(orderId, OrderState.DONE);
    }

    @PostMapping("/customer/create")
    public void createOrder(final @RequestBody CreateOrderDTO order){
        orderService.createOrder(order.getCostumerId(), order.getAddress(), order.isStorePickUp());
    }

    @PostMapping("/customer/shoppingCart/product")
    public void addProductToShoppingCart(final @RequestBody AddProductToShoppingCartDTO product){
        orderService.addProductToShoppingCart(product.getCostumerId(),
                                              product.getProductId(),
                                              product.getMaterialId(),
                                              product.getQuantity());
    }

    @PostMapping("/customer/shoppingCart/quantity")
    public void setProductQuantityInShoppingCart(final @RequestBody SetProductQuantityDTO product){
        orderService.setProductQuantity(product.getItemId(), product.getQuantity());
    }

    @DeleteMapping("/customer/shoppingCart/product/{itemId}")
    public void deleteProductFromShoppingCart(@PathVariable int itemId){
        orderService.deleteItemFromShoppingCart(itemId);
    }



}
