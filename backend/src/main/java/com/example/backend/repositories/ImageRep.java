package com.example.backend.repositories;

import com.example.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRep extends JpaRepository<Image, Integer> {

    Image findByImage(byte[] image);
}
