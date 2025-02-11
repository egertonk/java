//package com.ns.nearby_solutions.payment;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/payments")
//public class PaymentController {
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @GetMapping("/rental/{rentalOrderHistoryId}")
//    public ResponseEntity<Payment> getByRentalOrderHistoryId(
//            @PathVariable Integer rentalOrderHistoryId) {
//        Payment payments = paymentService.getByRentalOrderHistoryId(rentalOrderHistoryId);
//        return payments == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(payments);
//    }
//
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<Payment>> getByUserId(@PathVariable Integer userId) {
//        List<Payment> payments = paymentService.getByUserId(userId);
//        return payments.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(payments);
//    }
//
//    @PostMapping
//    public ResponseEntity<Payment> savePayment(@RequestBody Payment paymentInfo) {
//        Payment savedPayment = paymentService.savePaymentInformation(paymentInfo);
//        return ResponseEntity.ok(savedPayment);
//    }
//}
