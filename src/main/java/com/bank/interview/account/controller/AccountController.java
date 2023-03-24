package com.bank.interview.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/account")
public class AccountController {
    @GetMapping
    public ResponseEntity<?> createAccount(){
        return ResponseEntity.ok("Rest is working");
    }
}
