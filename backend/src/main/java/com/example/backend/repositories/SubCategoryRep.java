package com.example.backend.repositories;

import com.example.backend.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRep extends JpaRepository<SubCategory, Integer> {
}
