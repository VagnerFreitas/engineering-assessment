package com.vagner.foodtruckfinder.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserNewDto {

    @NotBlank
    @Length(max = 255)
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
