package com.example.backend.repositories;

import com.example.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRep extends JpaRepository<Category, Integer> {
}
