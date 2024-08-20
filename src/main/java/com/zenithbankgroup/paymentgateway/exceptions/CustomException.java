package com.zenithbankgroup.paymentgateway.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 20/08/2024 1:16 AM
 * @project paymentgateway
 */

@NoArgsConstructor
@Getter
public class CustomException extends RuntimeException{

    protected String message;
    protected HttpStatus status;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public CustomException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public CustomException(String message, HttpStatusCode status) {
        this.message = message;
        this.status = HttpStatus.valueOf(status.value());
    }
}
