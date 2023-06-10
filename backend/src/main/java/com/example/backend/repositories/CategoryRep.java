package com.example.backend.repositories;

import com.example.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRep extends JpaRepository<Category, Integer> {
}
