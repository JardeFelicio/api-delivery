package com.jardefelicio.api_orders.modules.company.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponseDTO {
    @Schema(example = "1")
    private Long id;
    @Schema(example = "Meta LTDA")
    private String name;
    @Schema(example = "email@example.com")
    private String email;
    @Schema(example = "00000000000")
    private String document;
    @Schema(example = "BRAZIL")
    private String country;
    @Schema(example = "PI")
    private String state;
    @Schema(example = "TEREZINA")
    private String city;
    @Schema(example = "Fátima")
    @NotBlank(message = "neighborhood invalid")
    private String neighborhood;
    @Schema(example = "RUA 155, 157")
    private String street;
    @Schema(example = "00000000")
    private String zipcode;
    @Schema(example = "1140028922")
    private String phone;
}
