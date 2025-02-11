//package com.ns.nearby_solutions.payment;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PaymentService {
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    public Payment getByRentalOrderHistoryId(Integer rentalOrderHistoryId) {
//        return paymentRepository.findByRentalOrderHistoryId(rentalOrderHistoryId);
//    }
//
//    public Optional<Payment> getByJobPostingOrderHistoryId(Long paymentId) {
//        return paymentRepository.findByPaymentId(paymentId);
//    }
//
//    public List<Payment> getByUserId(Integer userId) {
//        return paymentRepository.findByUserId(userId);
//    }
//
//    public Payment savePaymentInformation(Payment paymentInfo) {
//        return paymentRepository.save(paymentInfo);
//    }
//}
