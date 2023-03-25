package com.bank.interview.account.service;

import com.bank.interview.account.entity.Account;
import com.bank.interview.account.entity.Transaction;
import com.bank.interview.account.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, @Lazy AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    public List getTransactionByAccount(Long accountId){
        return accountService.getAccountFromId(accountId).getTransactions();
    }

    public Transaction createTransaction(Long accountId, BigDecimal initialCredit) {
        //The whole transaction should be in a single unit as rollback is necessary for
        Account account = accountService.getAccountFromId(accountId);
        Transaction transaction = transactionRepository.save(new Transaction(account, initialCredit));
        account.setBalance(account.getBalance().add(initialCredit));
        accountService.update(account);
            return transaction;

    }
}
