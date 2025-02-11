package com.ns.nearby_solutions.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class PageRequestDTO {
    private int page = 0;
    private int size = 10;
    private String sortBy = "id";
    private String direction = "ASC";

    public Pageable toPageable() {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        return PageRequest.of(page, size, sort);
    }
}
