package com.ns.nearby_solutions.tool_rental.history;

import com.ns.nearby_solutions.customer.CustomerToolDetailsDTO;
import com.ns.nearby_solutions.customer.CustomerToolOrderDetailsDTO;
import com.ns.nearby_solutions.enums.OrderStatus;
import com.ns.nearby_solutions.tool_rental.ToolRentalListing;
import com.ns.nearby_solutions.user.User;
import com.ns.nearby_solutions.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/order-history")
@RequiredArgsConstructor
public class ToolOrderHistoryController {

    private final ToolOrderHistoryService service;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<ToolOrderHistory>> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        log.info("Received request for all orders with page={} and size={}", page, size);
        Page<ToolOrderHistory> orders = service.getAllOrders(page, size);

        return ResponseEntity.ok(orders);
    }

    @GetMapping("/renter/{renterId}/{orderStatus}")
    public ResponseEntity<Page<ToolOrderHistory>> getOrdersByRenterWithFilter(
            @PathVariable Long renterId,
            @PathVariable String orderStatus,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Received request for orders by renterId={}, orderStatus={}, page={}, size={}", renterId, orderStatus, page, size);

        Page<ToolOrderHistory> orders;

        if ("All".equalsIgnoreCase(orderStatus)) {
            orders = service.getOrdersByRenterId(renterId, page, size);
        } else {
            try {
                OrderStatus statusEnum = OrderStatus.fromString(orderStatus);
                orders = service.getOrdersByRenterIdWithFilter(renterId, statusEnum, page, size);
            } catch (IllegalArgumentException e) {
                log.error("Invalid order status: {}", orderStatus);
                return ResponseEntity.badRequest().build();
            }
        }

        return ResponseEntity.ok(orders);
    }


    @GetMapping("/{id}/{renterId}/{posterId}")
    public ResponseEntity<CustomerToolOrderDetailsDTO> getToolById(@PathVariable Long id, @PathVariable Long renterId, @PathVariable Long posterId) {
        Optional<ToolOrderHistory> order = service.getOrderById(id);
        User customer = userService.getUserById(renterId);
        User poster = userService.getUserById(posterId);

        log.info("Getting a specific tool information id: {}", id, " | userId: ", renterId, " | posterId: ", posterId);

        CustomerToolOrderDetailsDTO dto = new CustomerToolOrderDetailsDTO();
        dto.setCustomerInformation(customer);
        dto.setToolOrderHistory(order);
        dto.setPosterDetails(poster);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToolOrderHistory> getOrderById(@PathVariable Long id) {
        log.info("Received request for order ID={}", id);
        return service.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.warn("Order not found with id={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @PostMapping
    public ResponseEntity<ToolOrderHistory> createOrder(@RequestBody ToolOrderHistory order) {
        log.info("Received request to create order: {}", order);
        ToolOrderHistory savedOrder = service.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToolOrderHistory> updateOrder(
            @PathVariable Long id,
            @RequestBody ToolOrderHistory orderDetails) {
        log.info("Received request to update order ID={}", id);
        try {
            ToolOrderHistory updatedOrder = service.updateOrder(id, orderDetails);
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) {
            log.error("Error updating order: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        log.info("Received request to delete order ID={}", id);
        try {
            service.deleteOrder(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.error("Error deleting order: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
