package com.zenithbankgroup.paymentgateway.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 20/08/2024 1:31 PM
 * @project paymentgateway
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WebhookRequest {

    private String transactionId;
    private String status;
}
