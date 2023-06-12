package com.example.backend.repositories;

import com.example.backend.model.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkRep extends JpaRepository<SocialNetwork, Integer>{
}
