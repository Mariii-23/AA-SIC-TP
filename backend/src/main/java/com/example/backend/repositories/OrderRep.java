package com.example.backend.repositories;

import com.example.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRep extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer_iD(final int customerId);
}
