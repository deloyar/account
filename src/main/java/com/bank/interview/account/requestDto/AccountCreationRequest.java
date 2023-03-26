package com.bank.interview.account.requestDto;


import com.bank.interview.account.util.AccountType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class AccountCreationRequest {
    @NotNull(message = "Customer Id is required.")
    private Long customerId;
    @NotNull(message = "Initial credit is required.")
    private BigDecimal initialCredit;

    private AccountType accountType;
    public AccountCreationRequest(){}

    public AccountCreationRequest(Long customerId, BigDecimal initialCredit, AccountType accountType) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
        this.accountType = accountType;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(BigDecimal initialCredit) {
        this.initialCredit = initialCredit;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
