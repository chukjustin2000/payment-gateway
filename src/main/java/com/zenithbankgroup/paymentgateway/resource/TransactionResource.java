package com.zenithbankgroup.paymentgateway.resource;

import com.zenithbankgroup.paymentgateway.request.TransactionRequest;
import com.zenithbankgroup.paymentgateway.response.AppResponse;
import com.zenithbankgroup.paymentgateway.response.TransactionResponse;
import com.zenithbankgroup.paymentgateway.services.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 19/08/2024 5:01 PM
 * @project paymentgateway
 */

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transaction API")
public class TransactionResource {

    public final TransactionService transactionService;

    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<AppResponse<TransactionResponse>> initiateTransaction(@RequestBody TransactionRequest transactionRequest){
        TransactionResponse transactionResponse = transactionService.initiateService(transactionRequest);
        return  ResponseEntity.ok().body(AppResponse.<TransactionResponse>builder()
                        .message("sucess")
                        .data(transactionResponse)
                        .status(HttpStatus.OK.value())
                    .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppResponse<TransactionResponse>> getTransactionStatus(Long id){
        TransactionResponse transactionResponse = transactionService.getTransactionStatus(id);
        return ResponseEntity.ok().body(AppResponse.<TransactionResponse>builder()
                        .data(transactionResponse)
                        .message("Status successfully fetched")
                        .status(HttpStatus.OK.value())
                .build());

    }

    @PostMapping("/{id}/status")
    public ResponseEntity<AppResponse<TransactionResponse>> updateTransactionStatus(@PathVariable Long id, @RequestParam String status) {
        TransactionResponse transactionResponse = transactionService.updateTransactionStatus(id,status);
        return ResponseEntity.ok().body(AppResponse.<TransactionResponse>builder()
                .data(transactionResponse)
                .message("Transaction Status updated")
                .status(HttpStatus.OK.value())
                .build());
    }
}
