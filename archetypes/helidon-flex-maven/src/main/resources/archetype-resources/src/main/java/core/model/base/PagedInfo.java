#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PagedInfo {
    int pageSize;
    int pageIndex;
    int itemCount;
    long itemTotal;

    public static PagedInfo empty() {
        return new PagedInfo(0, 0, 0, 0);
    }
}
