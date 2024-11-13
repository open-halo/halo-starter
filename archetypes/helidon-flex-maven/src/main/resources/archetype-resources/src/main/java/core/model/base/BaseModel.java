#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.model.base;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@Valid
@Data
public class BaseModel {

    @NotNull
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
