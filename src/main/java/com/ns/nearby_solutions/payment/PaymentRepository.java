//package com.ns.nearby_solutions.payment;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.List;
//import java.util.Optional;
//
//public interface PaymentRepository extends JpaRepository<Payment, Long> {
//    Payment findByRentalOrderHistoryId(Integer rentalOrderHistoryId);
//    List<Payment> findByUserId(Integer userId);
//    Optional<Payment> findByPaymentId(Long paymentId);
//}
