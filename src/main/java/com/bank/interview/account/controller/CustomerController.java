package com.bank.interview.account.controller;

import com.bank.interview.account.requestDto.CustomerRequest;
import com.bank.interview.account.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public ResponseEntity<?> getCustomers(){
        return ResponseEntity.ok(customerService.getAll());
    }
    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerRequest customer){

        return new ResponseEntity<>(customerService.crateCustomer(customer.getFirstName(), customer.getSurName()), HttpStatus.CREATED);
    }

}
