package com.bank.interview.account;

import com.bank.interview.account.entity.Customer;
import com.bank.interview.account.repository.CustomerRepository;
import com.bank.interview.account.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountApplication {
	private static final Logger log = LoggerFactory.getLogger(AccountApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerService customerService) {
		return (args) -> {
			customerService.crateCustomer("Deloyar", "Hossain");

			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customerService.getAll()) {
				log.info(customer.toString());
			}
			log.info("");

			Customer customer = customerService.getByID(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
		};
	}

}
