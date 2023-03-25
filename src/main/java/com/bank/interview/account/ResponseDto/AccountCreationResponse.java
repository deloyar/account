package com.bank.interview.account.ResponseDto;

import com.bank.interview.account.entity.Account;
import com.bank.interview.account.entity.Transaction;

public class AccountCreationResponse {
    private Account account;
    private Transaction transaction;

    public AccountCreationResponse(){}
    public AccountCreationResponse(Account account, Transaction transaction) {
        this.account = account;
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
