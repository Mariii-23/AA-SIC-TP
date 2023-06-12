package com.example.backend.repositories;

import com.example.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRep extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer_iD(final int customerId);
}
