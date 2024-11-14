package com.example.halo.infra.persistent.entity.base;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDateTime;


@Valid
@Data
public class BaseEntity {

    @NotNull
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
