package com.ns.nearby_solutions.tool_rental.history;

import com.ns.nearby_solutions.enums.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ToolOrderHistoryService {

    private final ToolOrderHistoryRepository repository;

    public Page<ToolOrderHistory> getAllOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        log.info("Fetching all orders - Page: {}, Size: {}", page, size);
        return repository.findAll(pageable);
    }

    public Page<ToolOrderHistory> getOrdersByRenterIdWithFilter(Long renterId, OrderStatus orderStatus, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        log.info("Fetching orders for renterId={}, :orderStatus={} page={}, size={}", orderStatus, renterId, page, size);
        return repository.findByRenterIdAndOrderStatus(renterId, orderStatus, pageable);
    }

    public Page<ToolOrderHistory> getOrdersByRenterId(Long renterId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        log.info("Fetching orders for renterId={}, page={}, size={}", renterId, page, size);
        return repository.findByRenterId(renterId, pageable);
    }

    public Optional<ToolOrderHistory> getOrderById(Long id) {
        log.info("Fetching order by id: {}", id);
        return repository.findById(id);
    }

    @Transactional
    public ToolOrderHistory createOrder(ToolOrderHistory order) {
        log.info("Creating new order: {}", order);
        return repository.save(order);
    }

    @Transactional
    public ToolOrderHistory updateOrder(Long id, ToolOrderHistory orderDetails) {
        log.info("Updating order with id: {}", id);

        return repository.findById(id).map(order -> {
            if (orderDetails.getRentStartDate() != null) {
                order.setRentStartDate(orderDetails.getRentStartDate());
            }
            if (orderDetails.getRentEndDate() != null) {
                order.setRentEndDate(orderDetails.getRentEndDate());
            }
            if (orderDetails.getReturnDate() != null) {
                order.setReturnDate(orderDetails.getReturnDate());
            }
            if (orderDetails.getPricePerDay() != null) {
                order.setPricePerDay(orderDetails.getPricePerDay());
            }
            if (orderDetails.getTotalPrice() != null) {
                order.setTotalPrice(orderDetails.getTotalPrice());
            }
            if (orderDetails.getFinalPrice() != null) {
                order.setFinalPrice(orderDetails.getFinalPrice());
            }
            if (orderDetails.getOrderStatus() != null) {
                order.setOrderStatus(orderDetails.getOrderStatus());
            }
            if (orderDetails.getPaymentStatus() != null) {
                order.setPaymentStatus(orderDetails.getPaymentStatus());
            }
            if (orderDetails.getShippingStatus() != null) {
                order.setShippingStatus(orderDetails.getShippingStatus());
            }
            if (orderDetails.getShippingCost() != null) {
                order.setShippingCost(orderDetails.getShippingCost());
            }
            if (orderDetails.getDiscountPercent() != null) {
                order.setDiscountPercent(orderDetails.getDiscountPercent());
            }
//            if (orderDetails.getEstimatedDelivery() != null) {
//                order.setEstimatedDelivery(orderDetails.getEstimatedDelivery());
//            }
            if (orderDetails.getIsShippingValid() != null) {
                order.setIsShippingValid(orderDetails.getIsShippingValid());
            }
            if (orderDetails.getToolZipcode() != null) {
                order.setToolZipcode(orderDetails.getToolZipcode());
            }
            if (orderDetails.getToolName() != null) {
                order.setToolName(orderDetails.getToolName());
            }
            if (orderDetails.getToolCategory() != null) {
                order.setToolCategory(orderDetails.getToolCategory());
            }
            if (orderDetails.getToolBrand() != null) {
                order.setToolBrand(orderDetails.getToolBrand());
            }
            if (orderDetails.getToolAddress() != null) {
                order.setToolAddress(orderDetails.getToolAddress());
            }
            if (orderDetails.getToolCity() != null) {
                order.setToolCity(orderDetails.getToolCity());
            }
            if (orderDetails.getToolState() != null) {
                order.setToolState(orderDetails.getToolState());
            }
            if (orderDetails.getToolCountry() != null) {
                order.setToolCountry(orderDetails.getToolCountry());
            }
            if (orderDetails.getDescription() != null) {
                order.setDescription(orderDetails.getDescription());
            }
            if (orderDetails.getPowerSource() != null) {
                order.setPowerSource(orderDetails.getPowerSource());
            }
            if (orderDetails.getRentalDays() != null) {
                order.setRentalDays(orderDetails.getRentalDays());
            }
            if (orderDetails.getImageUrls() != null && !orderDetails.getImageUrls().isEmpty()) {
                order.setImageUrls(orderDetails.getImageUrls());
            }

            return repository.save(order);
        }).orElseThrow(() -> {
            log.error("Order not found with id: {}", id);
            return new RuntimeException("Order not found with id: " + id);
        });
    }

    @Transactional
    public void deleteOrder(Long id) {
        log.info("Deleting order with id: {}", id);
        if (!repository.existsById(id)) {
            log.error("Order not found with id: {}", id);
            throw new RuntimeException("Order not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
