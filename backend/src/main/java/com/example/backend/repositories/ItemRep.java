package com.example.backend.repositories;

import com.example.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRep extends JpaRepository<Item, Integer> {
    List<Item> findByShoppingCart_iD(int iD);

    @Modifying
    @Query("DELETE FROM Item i WHERE i.iD = ?1")
    void deleteById(int iD);
}
