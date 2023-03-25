package com.bank.interview.account.service;

import com.bank.interview.account.entity.Customer;
import com.bank.interview.account.exception.NoDataFoundException;
import com.bank.interview.account.repository.CustomerRepository;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer crateCustomer(String firstName, String surName){
        return this.customerRepository.save(new Customer(firstName, surName));
    }

    public Customer getByID(Long cId){
        return this.customerRepository.findById(cId).orElseThrow(()->new NoDataFoundException("Customer not found"));
    }

    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }
}
