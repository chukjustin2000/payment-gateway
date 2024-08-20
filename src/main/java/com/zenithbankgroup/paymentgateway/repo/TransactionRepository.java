package com.zenithbankgroup.paymentgateway.repo;

import com.zenithbankgroup.paymentgateway.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chukwuka Justine Egbujio.
 * @created 19/08/2024 4:08 PM
 * @project paymentgateway
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
