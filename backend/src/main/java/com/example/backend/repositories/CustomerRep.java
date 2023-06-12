package com.example.backend.repositories;

import com.example.backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRep extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
}
