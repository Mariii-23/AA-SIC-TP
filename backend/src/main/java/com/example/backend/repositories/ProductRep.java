package com.example.backend.repositories;

import com.example.backend.model.Material;
import com.example.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRep extends JpaRepository<Product, Integer> {
    @Query("SELECT p, m FROM Product p inner join p.materials m WHERE p.iD = :id AND m.iD = :materialId")
    List<Object[]> findProductAndMaterialById(int id, int materialId);

}
