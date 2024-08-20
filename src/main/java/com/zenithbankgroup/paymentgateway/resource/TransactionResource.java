package com.zenithbankgroup.paymentgateway.resource;

import com.zenithbankgroup.paymentgateway.request.TransactionRequest;
import com.zenithbankgroup.paymentgateway.response.AppResponse;
import com.zenithbankgroup.paymentgateway.response.TransactionResponse;
import com.zenithbankgroup.paymentgateway.services.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<AppResponse<TransactionResponse>> initiateTransaction(@RequestBody(required = false) TransactionRequest transactionRequest){
        TransactionResponse transactionResponse = transactionService.initiateService(transactionRequest);
        return  ResponseEntity.ok().body(AppResponse.<TransactionResponse>builder()
                        .message("success")
                        .data(transactionResponse)
                        .status(HttpStatus.CREATED.value())
                    .build());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<AppResponse<TransactionResponse>> getTransactionStatus(@PathVariable Long id){
        TransactionResponse transactionResponse = transactionService.getTransactionStatus(id);
        return ResponseEntity.ok().body(AppResponse.<TransactionResponse>builder()
                        .data(transactionResponse)
                        .message("Status successfully fetched")
                        .status(HttpStatus.OK.value())
                .build());

    }

    //http://localhost:8080/api/transactions/fae3955b-35c6-4b46-bd0a-feb23b327144/status?status=successful
    @PostMapping("/{transactionId}/status")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AppResponse<TransactionResponse>> updateTransactionStatus(@PathVariable String transactionId, @RequestParam String status) {
        TransactionResponse transactionResponse = transactionService.updateTransactionStatus(transactionId,status);
        return ResponseEntity.ok().body(AppResponse.<TransactionResponse>builder()
                .data(transactionResponse)
                .message("Transaction Status updated")
                .status(HttpStatus.OK.value())
                .build());
    }
}
