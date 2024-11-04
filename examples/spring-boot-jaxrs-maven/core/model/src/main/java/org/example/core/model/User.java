package org.example.core.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull
    Long   id;

    @NotBlank
    String name;

    @Email
    String email;

    @Pattern(regexp = "^1[3-9]\\d{9}$")
    String cellphone;
}
