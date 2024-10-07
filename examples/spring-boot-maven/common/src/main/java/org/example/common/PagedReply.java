package org.example.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PagedReply<T> {
    PagedInfo pagedInfo;
    List<T> data;

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public static <T> PagedReply<T> empty() {
        return PagedReply.<T>builder().pagedInfo(PagedInfo.empty()).data(new ArrayList<>()).build();
    }
}

