package com.example.backend.event;

import com.example.backend.model.Customer;
import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {
    private Customer customer;
    private String message;

    public EmailEvent(Object source, Customer customer, String message) {
        super(source);
        this.customer = customer;
        this.message = message;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getMessage() {
        return message;
    }
}
