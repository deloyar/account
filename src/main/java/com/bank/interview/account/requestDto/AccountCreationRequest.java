package com.bank.interview.account.requestDto;


import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class AccountCreationRequest {
    @NotNull(message = "Customer Id is required.")
    private Long customerId;
    @NotNull(message = "Initial credit is required.")
    private BigDecimal initialCredit;
    public AccountCreationRequest(){}

    public AccountCreationRequest(Long customerId, BigDecimal initialCredit) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
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
}
