package com.zenithbankgroup.paymentgateway.services.impl;

import com.zenithbankgroup.paymentgateway.entity.Transaction;
import com.zenithbankgroup.paymentgateway.enums.TransactionStatus;
import com.zenithbankgroup.paymentgateway.exceptions.CustomException;
import com.zenithbankgroup.paymentgateway.repo.TransactionRepository;
import com.zenithbankgroup.paymentgateway.request.TransactionRequest;
import com.zenithbankgroup.paymentgateway.response.TransactionResponse;
import com.zenithbankgroup.paymentgateway.services.TransactionService;
import com.zenithbankgroup.paymentgateway.utils.ModelMapperUtils;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 19/08/2024 4:59 PM
 * @project paymentgateway
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public TransactionResponse initiateService(TransactionRequest transactionRequest) {

        Transaction transaction = transactionRepository.save(Transaction.builder()
                .amount(transactionRequest.getAmount())
                .status(TransactionStatus.PENDING)
                .currency(transactionRequest.getCurrency())
                .description(transactionRequest.getDescription())
                .destinationAccount(transactionRequest.getDestinationAccount())
                .recipientName(transactionRequest.getRecipientName())
                .sourceBank(transactionRequest.getSourceBank())
                .destinationBank(transactionRequest.getDestinationBank())
                .reference(transactionRequest.getReference())
                .senderName(transactionRequest.getSenderName())
                .build());

        return ModelMapperUtils.map(transaction, TransactionResponse.class);
    }

    @Override
    public TransactionResponse getTransactionStatus(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()->
                new CustomException("Transaction not found", HttpStatus.NOT_FOUND));

        return ModelMapperUtils.map(transaction, TransactionResponse.class);
    }

    @Override
    public TransactionResponse updateTransactionStatus(Long id, String status) {
        if(!EnumUtils.isValidEnumIgnoreCase(TransactionStatus.class, status)){
            throw  new CustomException("Invalid Transaction Status", HttpStatus.NOT_ACCEPTABLE);
        }
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()->
                new CustomException("Transaction not found", HttpStatus.NOT_FOUND));

        return ModelMapperUtils.map(transaction, TransactionResponse.class);
    }
}
