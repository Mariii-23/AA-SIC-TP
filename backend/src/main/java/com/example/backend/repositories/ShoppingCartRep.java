package com.example.backend.repositories;

import com.example.backend.model.Item;
import com.example.backend.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRep extends JpaRepository<ShoppingCart, Integer> {
}
