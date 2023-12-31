package com.example.backend.repositories;

import com.example.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRep extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer_iD(final int customerId);

    @Query(value = "SELECT * FROM _order " +
            "WHERE customer_id = ?1 " +
            "ORDER BY id ASC " +
            "LIMIT ?3 OFFSET ?2", nativeQuery = true)
    List<Order> findCustomerOrdersPagination(int id, int offset, int numitems);

    @Query(value = "SELECT * FROM _order " +
            "ORDER BY id ASC " +
            "LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Order> findOrdersPagination(int offset, int numitems);

    @Query(value = "SELECT * FROM _order " +
            "WHERE state=0 " +
            "ORDER BY id ASC " +
            "LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Order> findPendingOrdersPagination(int offset, int numItems);

    @Query(value = "SELECT * FROM _order " +
            "WHERE state=1 " +
            "ORDER BY id ASC " +
            "LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Order> findReadyOrdersPagination(int offset, int numItems);

    @Query(value = "SELECT * FROM _order " +
            "WHERE state=2 " +
            "ORDER BY id ASC " +
            "LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Order> findDoneOrdersPagination(int offset, int numItems);

    @Query(value = "SELECT COUNT(*) FROM _order " +
            "WHERE state = ?1", nativeQuery = true)
    int countOrdersByState(int state);
}
