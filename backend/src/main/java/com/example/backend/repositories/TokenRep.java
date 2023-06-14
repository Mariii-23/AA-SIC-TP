package com.example.backend.repositories;

import com.example.backend.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRep extends JpaRepository<Token, Integer> {
    Optional<Token> findByToken(String token);
}
