package com.example.backend.dto;

import com.example.backend.model.Order;
import com.example.backend.model.OrderState;

import java.time.LocalDate;

public class OrderSimpleDTO {
    private int id;
    private LocalDate date;
    private double total;
    private OrderState state;

    private int customer_id;


    public OrderSimpleDTO() {
    }

    public OrderSimpleDTO(int order_id, LocalDate date, double total, OrderState state, int customer_id) {
        this.id = order_id;
        this.date = date;
        this.total = total;
        this.state = state;
        this.customer_id = customer_id;
    }

    public OrderSimpleDTO(Order order){
        this.id = order.getiD();
        this.date = order.getDate();
        this.total = order.getTotal();
        this.state = order.getState();
        this.customer_id = order.getCustomer().getiD();
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
