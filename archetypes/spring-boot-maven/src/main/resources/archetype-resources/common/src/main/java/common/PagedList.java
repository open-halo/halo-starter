#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PagedList<T> {
    PagedInfo pagedInfo;
    List<T> data;

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public static <T> PagedList<T> empty() {
        return PagedList.<T>builder().pagedInfo(PagedInfo.empty()).data(new ArrayList<>()).build();
    }
}

