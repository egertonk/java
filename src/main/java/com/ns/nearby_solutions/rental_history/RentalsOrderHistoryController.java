//package com.ns.nearby_solutions.rental_history;
//
//import com.ns.nearby_solutions.payment.Payment;
//import com.ns.nearby_solutions.payment.PaymentService;
//import com.ns.nearby_solutions.payment.ToolRentalAndPaymentDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/tools-rental-order-history")
//public class RentalsOrderHistoryController {
//
//    @Autowired
//    private RentalsOrderHistoryService service;
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @GetMapping
//    public List<RentalsOrderHistory> getAllRentals() {
//        return service.getAllRentals();
//    }
//
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<RentalsOrderHistory>> getRentalsByUserrId(@PathVariable Integer userId) {
//        List<RentalsOrderHistory> rentals = service.getRentalsByUserId(userId);
//        return rentals.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(rentals);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ToolRentalAndPaymentDTO> getRentalWithPaymentDetails(@PathVariable Integer id) {
//        // Fetch rental details
//        RentalsOrderHistory rental = service.getRentalById(id);
//        if (rental == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        // Fetch payment details for the rental
//        Payment paymentDetails = paymentService.getByRentalOrderHistoryId(id);
//        if (paymentDetails == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        // For simplicity, assume the first payment record corresponds to the rental
//        Payment paymentInfo = paymentDetails;
//
//        // Combine into DTO
//        ToolRentalAndPaymentDTO fullDetails = new ToolRentalAndPaymentDTO(rental, paymentInfo);
//
//        return ResponseEntity.ok(fullDetails);
//
//    }
//
//    @GetMapping("/date")
//    public List<RentalsOrderHistory> getRentalsByDate(@RequestParam("date") String date) {
//        LocalDateTime dateTime = LocalDateTime.parse(date);
//        return service.getRentalsByDate(dateTime);
//    }
//
//    @GetMapping("/range")
//    public List<RentalsOrderHistory> getRentalsByDateRange(
//            @RequestParam("startDate") String startDate,
//            @RequestParam("endDate") String endDate) {
//        LocalDateTime start = LocalDateTime.parse(startDate);
//        LocalDateTime end = LocalDateTime.parse(endDate);
//        return service.getRentalsByDateRange(start, end);
//    }
//
//    @PostMapping
//    public RentalsOrderHistory createRental(@RequestBody RentalsOrderHistory rental) {
//        return service.saveRental(rental);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRental(@PathVariable Integer id) {
//        service.deleteRental(id);
//        return ResponseEntity.noContent().build();
//    }
//}
