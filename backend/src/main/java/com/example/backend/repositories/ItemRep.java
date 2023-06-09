package com.example.backend.repositories;

import com.example.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRep extends JpaRepository<Item, Integer> {

    List<Item> findByShoppingCart_iD(int iD);
}
