package com.example.backend.repositories;

import com.example.backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRep extends JpaRepository<Admin, Integer> {

    @Query(value = "SELECT * FROM user WHERE role='ADMIN' ORDER BY id ASC LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Admin> findAdminPagination(int offset, int numItems);

    @Query(value = "SELECT COUNT(*) FROM user WHERE role='ADMIN'", nativeQuery = true)
    int getNumberOfAdmins();

    @Query(value = "SELECT * FROM user WHERE role='ADMIN' AND name LIKE %?1% LIMIT 1", nativeQuery = true)
    Optional<Admin> findByName(String name);
}
