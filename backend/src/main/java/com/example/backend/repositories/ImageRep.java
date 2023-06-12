package com.example.backend.repositories;

import com.example.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRep extends JpaRepository<Image, Integer> {

    Image findByPath(String path);
}
