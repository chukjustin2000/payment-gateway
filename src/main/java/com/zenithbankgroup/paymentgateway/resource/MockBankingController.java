package com.zenithbankgroup.paymentgateway.resource;

import com.zenithbankgroup.paymentgateway.services.MockBankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 20/08/2024 3:12 PM
 * @project paymentgateway
 */

@RestController
@RequestMapping("/api/mock-banking")
public class MockBankingController {
    @Autowired
    private MockBankingService mockBankingService;

    @PostMapping("/send-update")
    public ResponseEntity<Void> sendTransactionUpdate(@RequestParam String transactionId, @RequestParam String status) {
        mockBankingService.sendTransactionUpdate(transactionId, status);
        return ResponseEntity.ok().build();
    }
}
