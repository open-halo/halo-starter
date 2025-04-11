package org.example.halo.core.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public class BaseModel {

    @Id
    @NotNull
    private Long id;

    @Transient
    private LocalDateTime createTime;

    @Transient
    private LocalDateTime updateTime;
}
