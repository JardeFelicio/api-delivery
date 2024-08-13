package com.jardefelicio.api_orders.modules.auth.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDTO {

    @Email(message = "email invalid")
    @NotBlank(message = "email invalid")
    private String email;
    @Size(min = 6, max = 100, message = "password invalid")
    private String password;

}
