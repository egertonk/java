package com.ns.nearby_solutions.tool_rental.history;

import com.ns.nearby_solutions.enums.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolOrderHistoryRepository extends JpaRepository<ToolOrderHistory, Long> {
    @Query("SELECT t FROM ToolOrderHistory t WHERE t.renterId = :renterId")
    Page<ToolOrderHistory> findByRenterId(@Param("renterId") Long renterId, Pageable pageable);

    @Query("SELECT t FROM ToolOrderHistory t WHERE t.renterId = :renterId AND t.orderStatus = :orderStatus")
    Page<ToolOrderHistory> findByRenterIdAndOrderStatus(
            @Param("renterId") Long renterId,
            @Param("orderStatus") OrderStatus orderStatus,
            Pageable pageable);

}