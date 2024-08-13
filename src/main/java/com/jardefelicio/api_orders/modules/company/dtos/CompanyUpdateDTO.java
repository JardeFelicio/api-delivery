package com.jardefelicio.api_orders.modules.company.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyUpdateDTO {
    @Schema(example = "Meta LTDA")
    @Size(min = 3, max = 50, message = "name invalid")
    private String name;

    @Schema(example = "email@example.com")
    @Email(message = "email invalid")
    private String email;

    @Schema(example = "00000000000")
    @Size(min = 14, max = 14, message = "document invalid")
    private String document;

    @Schema(example = "BRAZIL")
    @NotBlank(message = "country invalid")
    private String country;

    @Schema(example = "PI")
    @NotBlank(message = "state invalid")
    private String state;

    @Schema(example = "TEREZINA")
    @NotBlank(message = "city invalid")
    private String city;

    @Schema(example = "Fátima")
    @NotBlank(message = "neighborhood invalid")
    private String neighborhood;

    @Size(min = 6, max = 100, message = "password invalid")
    private String password;

    @Schema(example = "RUA 155, 157")
    @NotBlank(message = "street invalid")
    private String street;

    @Schema(example = "00000000")
    @Size(min = 8, message = "zipCode invalid")
    private String zipCode;

    @Schema(example = "1140028922")
    @Size(min = 10, max = 11, message = "phone invalid")
    private String phone;
}
