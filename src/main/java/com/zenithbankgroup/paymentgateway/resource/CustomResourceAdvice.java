package com.zenithbankgroup.paymentgateway.resource;

import com.zenithbankgroup.paymentgateway.exceptions.CustomException;
import com.zenithbankgroup.paymentgateway.exceptions.model.ErrorDetail;
import com.zenithbankgroup.paymentgateway.response.AppResponse;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 20/08/2024 1:18 AM
 * @project paymentgateway
 */

@RestControllerAdvice
public class CustomResourceAdvice {

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<AppResponse<ErrorDetail>> handleCustomException(CustomException ex, WebRequest request) {
        ErrorDetail errorDetails = ErrorDetail.builder()
                .message(ex.getMessage())
                .code(ex.getStatus().value() != 0 ? ex.getStatus().value() : HttpStatus.PRECONDITION_FAILED.value())
                .details(request.getDescription(true))
                .timestamp(new Date())
                .build();
        return ResponseEntity.status(errorDetails.getCode()).body(AppResponse.<ErrorDetail>builder()
                .message(errorDetails.getMessage())
                .status(errorDetails.getCode())
                .error(errorDetails)
                .build());
    }
}
