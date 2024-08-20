package com.zenithbankgroup.paymentgateway.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 20/08/2024 12:22 AM
 * @project paymentgateway
 */

@Getter
@AllArgsConstructor
public enum TransactionStatus {
    PENDING("PENDING"),
    REJECTED("REJECTED"),
    SUCCESSFUL("SUCCESSFUL");

    private String status;

}
