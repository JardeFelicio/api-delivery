package com.jardefelicio.api_orders.modules.customer.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerResponseDTO {
    @Schema(example = "1")
    private Long id;

    @Schema(example = "JOAO")
    private String name;

    @Schema(example = "email@example.com")
    private String email;

    @Schema(example = "1140028922")
    private String phone;

    @Schema(example = "password")
    private String password;
}
