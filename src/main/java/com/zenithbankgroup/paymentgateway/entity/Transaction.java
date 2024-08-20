package com.zenithbankgroup.paymentgateway.entity;

import com.zenithbankgroup.paymentgateway.enums.TransactionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 19/08/2024 3:59 PM
 * @project paymentgateway
 */
@Entity
@Table(name = "TRANSACTIONS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private TransactionStatus status;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "reference")
    private String reference;

    @Column(name = "description")
    private String description;

    @Column(name = "currency")
    private String currency;

    @Column(name = "source_account")
    private String sourceAccount;

    @Column(name = "destination_account")
    private String destinationAccount;

    @Column(name = "source_bank")
    private String sourceBank;

    @Column(name = "destination_bank")
    private String destinationBank;

    @Column(name = "checksum")
    private String checksum;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "sender_name")
    private String senderName;

}
