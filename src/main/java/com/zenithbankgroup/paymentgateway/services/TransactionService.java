package com.zenithbankgroup.paymentgateway.services;

import com.zenithbankgroup.paymentgateway.request.TransactionRequest;
import com.zenithbankgroup.paymentgateway.response.TransactionResponse;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 19/08/2024 4:15 PM
 * @project paymentgateway
 */
public interface TransactionService {

    TransactionResponse initiateService(TransactionRequest transactionRequest);
    TransactionResponse getTransactionStatus(Long id);
    TransactionResponse updateTransactionStatus(Long id, String status);

}
