package com.example.backend.repositories;

import com.example.backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRep extends JpaRepository<OrderItem, Integer> {
}
