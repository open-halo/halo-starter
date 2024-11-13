package com.example.halo.core.model.base;


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
