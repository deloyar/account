package com.bank.interview.account.repository;

import com.bank.interview.account.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(long id);
    List findAll();
}
