package com.zenithbankgroup.paymentgateway.services.impl;

import com.zenithbankgroup.paymentgateway.request.WebhookRequest;
import com.zenithbankgroup.paymentgateway.services.MockBankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 20/08/2024 1:39 PM
 * @project paymentgateway
 */

@Service
public class MockBankingServiceImpl implements MockBankingService {

    private static final String URL = "http://localhost:8080/api/webhook/transaction-update";

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void sendTransactionUpdate(String transactionId, String status) {
        WebhookRequest webhookRequest = new WebhookRequest();
        webhookRequest.setTransactionId(transactionId);
        webhookRequest.setStatus(status);

        restTemplate.postForEntity(URL, webhookRequest,Void.class);
    }
}
