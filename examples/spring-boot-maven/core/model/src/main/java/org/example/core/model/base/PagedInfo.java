package org.example.core.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PagedInfo {
    long pageSize;
    long pageIndex;
    long itemCount;
    long itemTotal;

    public static PagedInfo empty() {
        return new PagedInfo(0, 0, 0, 0);
    }
}
