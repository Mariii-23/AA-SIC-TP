package com.example.backend.repositories;

import com.example.backend.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShoppingCartRep extends JpaRepository<ShoppingCart, Integer> {
}
