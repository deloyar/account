package com.bank.interview.account.controller;

import com.bank.interview.account.requestDto.AccountCreationRequest;
import com.bank.interview.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @PostMapping
    public ResponseEntity<?> createAccount(@Valid @RequestBody AccountCreationRequest accountCreationRequest){
        return ResponseEntity.ok(accountService.createAccount(accountCreationRequest));
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> getAccountTransaction(@RequestParam(name = "account") Long accountId){
        return ResponseEntity.ok(accountService.getAccountTransaction(accountId));
    }
}
