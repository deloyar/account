package com.bank.interview.account.repository;

import com.bank.interview.account.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);
}
