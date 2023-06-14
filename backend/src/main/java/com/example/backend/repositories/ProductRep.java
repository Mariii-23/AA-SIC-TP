package com.example.backend.repositories;

import com.example.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRep extends JpaRepository<Product, Integer> {
    @Query("SELECT p, m FROM Product p inner join p.materials m WHERE p.iD = :id AND m.iD = :materialId")
    List<Object[]> findProductAndMaterialById(int id, int materialId);

    @Query(value = "SELECT * FROM product" +
            " WHERE id IN (SELECT product_id FROM customer_favourites WHERE customer_id = ?1) " +
            "ORDER BY id ASC" +
            " LIMIT ?3 OFFSET ?2", nativeQuery = true)
    List<Product> findFavouritesPagination(int customer_id, int offset, int numItems);
}
