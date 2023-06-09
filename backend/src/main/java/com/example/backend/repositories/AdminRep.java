package com.example.backend.repositories;

import com.example.backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRep extends JpaRepository<Admin, Integer> {
}
