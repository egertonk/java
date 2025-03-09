package com.ns.nearby_solutions.job_posting.history;

import com.ns.nearby_solutions.tool_rental.history.ToolOrderHistory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobPostingsOrderHistoryService {
    private final JobPostingsOrderHistoryRepository repository;

    public Page<JobPostingsOrderHistory> getAllOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        log.info("Fetching all orders - Page: {}, Size: {}", page, size);
        return repository.findAll(pageable);
    }

    public Optional<JobPostingsOrderHistory> getOrderById(Long id) {
        return repository.findById(id);
    }

    public Page<JobPostingsOrderHistory> getOrdersByJobId(Long jobId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findByJobId(jobId, pageable);
    }

    public Page<JobPostingsOrderHistory> getOrdersBySolutionistId(Integer solutionistId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findBySolutionistId(solutionistId, pageable);
    }

    public Page<JobPostingsOrderHistory> getOrdersByPosterId(Long posterId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllByPosterId(posterId, pageable);
    }

    public JobPostingsOrderHistory createOrder(JobPostingsOrderHistory order) {
        return repository.save(order);
    }

    public Optional<JobPostingsOrderHistory> updateOrder(Long id, JobPostingsOrderHistory updatedOrder) {
        return repository.findById(id).map(existingOrder -> {
            updatedOrder.setOrderId(existingOrder.getOrderId());
            return repository.save(updatedOrder);
        });
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}

