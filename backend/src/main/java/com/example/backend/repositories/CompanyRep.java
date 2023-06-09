package com.example.backend.repositories;

import com.example.backend.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRep extends JpaRepository<Company, Integer> {
}
