package com.example.backend.repositories;

import com.example.backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRep extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE role='CUSTOMER' ORDER BY id ASC LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Customer> findCustomerPagination(int offset, int numItems);

    @Query(value = "SELECT COUNT(*) FROM user WHERE role='CUSTOMER'", nativeQuery = true)
    int getNumberOfCustomers();

    @Query(value = "SELECT count(*) FROM customer_favourites WHERE customer_id = ?1", nativeQuery = true)
    int getNumberOfFavourites(int customer_id);
}
