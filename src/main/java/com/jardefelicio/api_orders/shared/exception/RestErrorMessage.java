package com.jardefelicio.api_orders.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestErrorMessage {
    private HttpStatus error;
    private String message;
    private int statusCode;
}
