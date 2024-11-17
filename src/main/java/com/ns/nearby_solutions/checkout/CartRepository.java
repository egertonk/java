package com.ns.nearby_solutions.checkout;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    // Custom query to find all carts by customer ID
    List<Cart> findByCustomer_Id(Long customerId);
}
