package com.zenithbankgroup.paymentgateway.request;

import com.zenithbankgroup.paymentgateway.enums.TransactionStatus;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 19/08/2024 4:34 PM
 * @project paymentgateway
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TransactionRequest {
    private Long id;
    private Double amount;
    private String reference;
    private String description;
    private String currency;
    private String sourceAccount;
    private String destinationAccount;
    private String recipientName;
    private String senderName;
    private String sourceBank;
    private String destinationBank;
}
