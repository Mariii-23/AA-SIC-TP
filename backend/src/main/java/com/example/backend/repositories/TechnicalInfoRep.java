package com.example.backend.repositories;

import com.example.backend.model.TechnicalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalInfoRep extends JpaRepository<TechnicalInfo, Integer> {

    @Modifying
    @Query("DELETE FROM TechnicalInfo ti WHERE ti.iD = ?1")
    void deleteTechnicalInfoById(int id);
}
