package com.example.halo.core.model;

import com.example.halo.core.model.base.BaseModel;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Valid
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Store extends BaseModel  {

        @NotBlank
        String name;

        @NotBlank
        String website;

}
