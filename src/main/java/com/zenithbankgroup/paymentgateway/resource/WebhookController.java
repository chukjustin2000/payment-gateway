package com.zenithbankgroup.paymentgateway.resource;

import com.zenithbankgroup.paymentgateway.request.WebhookRequest;
import com.zenithbankgroup.paymentgateway.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 20/08/2024 1:29 PM
 * @project paymentgateway
 */

@RestController
@RequestMapping("/api/webhook")
public class WebhookController {

    private final TransactionService transactionService;

    public WebhookController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction-update")
    public ResponseEntity<Void> handleTransactionUpdate(@RequestBody WebhookRequest webhookRequest) {
        transactionService.updateTransactionStatus(webhookRequest.getTransactionId(), webhookRequest.getStatus());
        return ResponseEntity.ok().build();
    }
}
