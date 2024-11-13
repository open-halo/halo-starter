package com.example.halo.core.model;


import com.example.halo.core.model.base.BaseModel;
import com.example.halo.core.model.base.Gender;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Valid
@Data
@EqualsAndHashCode(callSuper=true)
public class Author extends BaseModel {

    Gender gender;

    @NotBlank

    @Size(min = 2, max=50, message = "The field must be at least {min} and at most {max} characters")
    String name;

    @Email
    String email;
}

