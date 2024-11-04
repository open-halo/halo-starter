package org.example.core.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Pagination {
    long pageSize;
    long pageIndex;
}
