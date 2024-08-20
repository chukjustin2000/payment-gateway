package com.zenithbankgroup.paymentgateway.services;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 20/08/2024 1:37 PM
 * @project paymentgateway
 */
public interface MockBankingService {
    void sendTransactionUpdate(String transactionId, String status);
}
