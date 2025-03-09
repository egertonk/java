package com.ns.nearby_solutions.job_posting.history;

import com.ns.nearby_solutions.tool_rental.history.ToolOrderHistory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/job-postings-order-history")
public class JobPostingsOrderHistoryController {
    private final JobPostingsOrderHistoryService service;

    @GetMapping
    public ResponseEntity<Page<JobPostingsOrderHistory>> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        log.info("Received request for all orders with page={} and size={}", page, size);
        Page<JobPostingsOrderHistory> orders = service.getAllOrders(page, size);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPostingsOrderHistory> getOrderById(@PathVariable Long id) {
        log.info("Fetching order by id: {}", id);
        return service.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/job/{jobId}")
    public Page<JobPostingsOrderHistory> getOrdersByJobId(@PathVariable Long jobId,
                                                          @RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size) {
        log.info("Fetching orders for jobId: {} - Page: {}, Size: {}", jobId, page, size);
        return service.getOrdersByJobId(jobId, page, size);
    }

    @GetMapping("/search/solutionist/{solutionistId}")
    public Page<JobPostingsOrderHistory> getOrdersBySolutionistId(@PathVariable Integer solutionistId,
                                                                  @RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "10") int size) {
        log.info("Fetching orders for solutionistId: {} - Page: {}, Size: {}", solutionistId, page, size);
        return service.getOrdersBySolutionistId(solutionistId, page, size);
    }

    @GetMapping("/search/poster/{posterId}")
    public ResponseEntity<Page<JobPostingsOrderHistory>> getOrdersByPosterId(@PathVariable Long posterId,
                                                                             @RequestParam(defaultValue = "0") int page,
                                                                             @RequestParam(defaultValue = "10") int size) {
        log.info("Fetching orders for posterId: {} - Page: {}, Size: {}", posterId, page, size);

        Page<JobPostingsOrderHistory> orders = service.getOrdersByPosterId(posterId, page, size);
        if (orders.isEmpty()) {
            return ResponseEntity.ok(Page.empty());
        }

        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<JobPostingsOrderHistory> createOrder(@RequestBody JobPostingsOrderHistory order) {
        log.info("Creating new order: {}", order);
        return ResponseEntity.ok(service.createOrder(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPostingsOrderHistory> updateOrder(@PathVariable Long id, @RequestBody JobPostingsOrderHistory order) {
        log.info("Updating order with id: {}", id);
        return service.updateOrder(id, order)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        log.info("Deleting order with id: {}", id);
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
