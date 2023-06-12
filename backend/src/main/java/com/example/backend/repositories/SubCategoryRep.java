package com.example.backend.repositories;

import com.example.backend.model.Category;
import com.example.backend.model.Material;
import com.example.backend.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface SubCategoryRep extends JpaRepository<SubCategory, Integer> {

    @Query("SELECT s.category FROM SubCategory s WHERE s.iD = :subcategory_id")
    Category findCategoryById(int subcategory_id);
}
