package com.bank.interview.account.exception;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException() {

        super("No data found");
    }
}
