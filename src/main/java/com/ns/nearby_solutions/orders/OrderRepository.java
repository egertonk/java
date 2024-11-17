package com.ns.nearby_solutions.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Find orders by contractor ID
    List<Order> findByContractorId(Integer contractorId);
}
