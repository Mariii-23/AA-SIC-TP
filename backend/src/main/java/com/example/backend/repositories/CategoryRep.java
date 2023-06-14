package com.example.backend.repositories;

import com.example.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRep extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT * FROM category " +
            "ORDER BY id ASC " +
            "LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Category> findAllPagination(int offset, int numItems);
}
