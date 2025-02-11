//package com.ns.nearby_solutions.rental_history;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Repository
//public interface RentalsOrderHistoryRepository extends JpaRepository<RentalsOrderHistory, Integer> {
//    List<RentalsOrderHistory> findByPickupDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
//
//    List<RentalsOrderHistory> findByPickupDateTime(LocalDateTime date);
//
//    List<RentalsOrderHistory> findByUserId(Integer userId);
//}