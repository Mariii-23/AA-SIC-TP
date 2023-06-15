package com.example.backend.repositories;

import com.example.backend.model.Category;
import com.example.backend.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubCategoryRep extends JpaRepository<SubCategory, Integer> {

    @Query("SELECT s.category FROM SubCategory s WHERE s.iD = :subcategory_id")
    Category findCategoryById(int subcategory_id);

    @Query("SELECT s FROM SubCategory s WHERE s.iD = :subcategory_id and s.category.iD = :category_id")
    Optional<SubCategory> findByIdAndCategory_ID(int subcategory_id, int category_id);
}
