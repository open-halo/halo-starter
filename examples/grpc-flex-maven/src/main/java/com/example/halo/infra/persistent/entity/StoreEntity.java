package com.example.halo.infra.persistent.entity;

import com.example.halo.infra.persistent.entity.base.BaseEntity;
import com.mybatisflex.annotation.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Valid
@Data
@Table("store")
@EqualsAndHashCode(callSuper=true)
public class StoreEntity extends BaseEntity {

    @NotBlank
    private String name;

    @NotBlank
    private String website;
}
