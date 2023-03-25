package com.bank.interview.account.requestDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CustomerRequest {
    @NotEmpty(message = "First name is required.")
    @Size(min = 2, max = 100, message = "The length of first name must be between 2 and 100 characters.")
    private String firstName;
    private String surName;
    public CustomerRequest(){}
    public CustomerRequest(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
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

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
