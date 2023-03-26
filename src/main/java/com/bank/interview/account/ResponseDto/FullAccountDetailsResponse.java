package com.bank.interview.account.ResponseDto;

import com.bank.interview.account.entity.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class FullAccountDetailsResponse {
    private Long id;
    private String firstName;
    private String surName;
    private BigDecimal Balance;
    private List<Transaction> transactions;

    public FullAccountDetailsResponse(){}

    public FullAccountDetailsResponse(Long id, String firstName, String surName, BigDecimal balance, List<Transaction> transactions) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        Balance = balance;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public BigDecimal getBalance() {
        return Balance;
    }

    public void setBalance(BigDecimal balance) {
        Balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
