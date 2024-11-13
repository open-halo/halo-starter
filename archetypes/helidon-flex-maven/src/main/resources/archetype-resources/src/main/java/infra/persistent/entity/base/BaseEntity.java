#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.entity.base;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDateTime;


@Valid
@Data
public class BaseEntity {
    @Id
    @NotNull
    private Long id;

    @Column(ignore = true)
    private LocalDateTime createTime;

    @Column(ignore = true)
    private LocalDateTime updateTime;
}
