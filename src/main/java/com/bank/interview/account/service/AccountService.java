package com.bank.interview.account.service;

import com.bank.interview.account.ResponseDto.AccountCreationResponse;
import com.bank.interview.account.ResponseDto.FullAccountDetailsResponse;
import com.bank.interview.account.entity.FullAccountDetails;
import com.bank.interview.account.entity.Account;
import com.bank.interview.account.entity.Customer;
import com.bank.interview.account.entity.Transaction;
import com.bank.interview.account.exception.CustomException;
import com.bank.interview.account.exception.NoDataFoundException;
import com.bank.interview.account.repository.AccountRepository;
import com.bank.interview.account.requestDto.AccountCreationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);
    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    private final TransactionService transactionService;

    @Autowired
    public AccountService(AccountRepository accountRepository, CustomerService customerService, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
    }

    public Account getAccountFromId(Long id){
        log.info("fetching account: " + id);
        return accountRepository.findById(id).orElseThrow(() -> new NoDataFoundException("Account not found"));
    }

    public FullAccountDetailsResponse getFullAccountFromId(Long id){
        log.info("fetching account: " + id);
        FullAccountDetails fullAccount = accountRepository.getAccountDetails(id).orElseThrow(() -> new NoDataFoundException("Account not found"));
        return new FullAccountDetailsResponse(fullAccount.getId(), fullAccount.getFirstName(), fullAccount.getSurname(), fullAccount.getBalance(), getAccountTransaction(fullAccount.getId()));
    }

    public List getAccountTransaction(Long accountId){
        return this.transactionService.getTransactionByAccount(accountId);
    }

    public Account update(Account account){
        return accountRepository.save(account);
    }

    public AccountCreationResponse createAccount(AccountCreationRequest accountCreationRequest) {
        if (accountCreationRequest.getInitialCredit().compareTo(BigDecimal.ZERO) < 0) {
            throw new CustomException("Negative Deposit not allowed");
        }
        Customer customer = customerService.getByID(accountCreationRequest.getCustomerId());
        Account account = accountRepository.save(new Account(customer, accountCreationRequest.getAccountType()));
        Transaction transaction = null;
        if (accountCreationRequest.getInitialCredit() != null && accountCreationRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            try {
                transaction = transactionService.createTransaction(account.getId(), accountCreationRequest.getInitialCredit());
            } catch (Exception ex) {
                log.info("Error during transaction: "+ ex.getStackTrace());
            }

        }
        return new AccountCreationResponse(account, transaction);
    }
}
