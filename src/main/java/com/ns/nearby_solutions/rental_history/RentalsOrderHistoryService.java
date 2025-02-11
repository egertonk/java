//package com.ns.nearby_solutions.rental_history;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class RentalsOrderHistoryService {
//
//    private static final Logger logger = LoggerFactory.getLogger(RentalsOrderHistoryService.class);
//
//    private final RentalsOrderHistoryRepository repository;
//
//    public RentalsOrderHistoryService(RentalsOrderHistoryRepository repository) {
//        this.repository = repository;
//    }
////    private final PaymentInformationService paymentInformationService;
////
////    public RentalsOrderHistoryService(RentalsOrderHistoryRepository repository,
////                                      PaymentInformationService paymentInformationService) {
////        this.repository = repository;
////        this.paymentInformationService = paymentInformationService;
////    }
//
//    public List<RentalsOrderHistory> getAllRentals() {
//        return repository.findAll();
//    }
//
//    public RentalsOrderHistory getRentalById(Integer id) {
//        System.out.println("------------------"+ repository.findById(id));
//        return repository.findById(id).orElse(null);
//    }
//
//    public List<RentalsOrderHistory> getRentalsByUserId(Integer userId) {
//        return repository.findByUserId(userId);
//    }
//
//    public List<RentalsOrderHistory> getRentalsByDate(LocalDateTime date) {
//        return repository.findByPickupDateTime(date);
//    }
//
//    public List<RentalsOrderHistory> getRentalsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
//        return repository.findByPickupDateTimeBetween(startDate, endDate);
//    }
//
//    public RentalsOrderHistory saveRental(RentalsOrderHistory rental) {
//        return repository.save(rental);
//    }
//
//    public void deleteRental(Integer id) {
//        repository.deleteById(id);
//    }
//}
