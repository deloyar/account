package com.bank.interview.account.repository;

import com.bank.interview.account.entity.FullAccountDetails;
import com.bank.interview.account.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query(value = "select account.id as id, customer.firstName as firstName, customer.surname as surname, account.balance as balance from account inner join customer on account.customer_id=customer.id where account.id=?1", nativeQuery = true)
    Optional<FullAccountDetails> getAccountDetails(Long id);
}
