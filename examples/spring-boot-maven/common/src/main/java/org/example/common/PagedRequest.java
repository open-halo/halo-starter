package org.example.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PagedRequest<T> {
    Pagination pagination;
    T request;
}
