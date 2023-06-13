package com.example.backend.repositories;

import com.example.backend.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface MaterialRep extends JpaRepository<Material, Integer> {
    @Query(value = "SELECT m FROM Material m WHERE m.iD IN :idList")
    Optional<List<Material>> findMaterialByIdList(@Param("idList") Collection<Integer> idList);
}
