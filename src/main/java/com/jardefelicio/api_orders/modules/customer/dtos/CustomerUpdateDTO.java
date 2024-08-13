package com.jardefelicio.api_orders.modules.customer.dtos;

import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateDTO {
    @Schema(example = "JOAO")
    @Size(min = 3, max = 50, message = "name invalid")
    private String name;

    @Schema(example = "email@example.com")
    @Email(message = "email invalid")
    private String email;

    @Schema(example = "1140028922")
    @Size(min = 10, max = 20, message = "phone invalid")
    private String phone;
    
    @Schema(example = "password")
    @Size(min = 6, max = 100, message = "password invalid")
    private String password;
}