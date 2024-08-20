package com.zenithbankgroup.paymentgateway.exceptions.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 20/08/2024 1:20 AM
 * @project paymentgateway
 */

@Setter
@Getter
@NoArgsConstructor
@Builder
public class ErrorDetail implements Serializable {

    private Date timestamp;
    private String message;
    private String details;
    private int code;

    public ErrorDetail(Date timestamp, String message, String details, int code) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.code = code;
    }
}
