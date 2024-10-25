package org.example.core.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PagedResult<T> {
    PagedInfo pagedInfo;
    List<T>   data;

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public static <T> PagedResult<T> empty() {
        return PagedResult.<T> builder().pagedInfo(PagedInfo.empty()).data(new ArrayList<>())
            .build();
    }
}
