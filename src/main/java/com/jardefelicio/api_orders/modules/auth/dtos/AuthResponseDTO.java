package com.jardefelicio.api_orders.modules.auth.dtos;


import java.util.List;


public record AuthResponseDTO(String token, Long expires_in, List<String> roles) {
}