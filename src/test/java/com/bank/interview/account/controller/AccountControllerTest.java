package com.bank.interview.account.controller;

import com.bank.interview.account.entity.Customer;
import com.bank.interview.account.requestDto.AccountCreationRequest;
import com.bank.interview.account.service.AccountService;
import com.bank.interview.account.service.CustomerService;
import com.bank.interview.account.util.AccountType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")

public class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;
    private final String ACCOUNT_CREATE_API="/account";
    public final ObjectMapper objectMapper = new ObjectMapper();
    @Test

    public void createAccount_whenCustomerIdExits_shouldCreateAccountAndReturnAccountCreationResponse_hasTransaction() throws Exception {

        Customer customer = customerService.crateCustomer("FName", "SName");
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest(customer.getId(), BigDecimal.ONE, AccountType.Current);

        this.mockMvc.perform(post(ACCOUNT_CREATE_API)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(accountCreationRequest)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.account.balance", is(1)))
                .andExpect(jsonPath("$.account.customer.firstName", is(customer.getFirstName())))
                .andExpect(jsonPath("$.account.customer.surname", is(customer.getSurname())))
                .andExpect(jsonPath("$.transaction", notNullValue()));
    }

    @Test
    public void createAccount_whenCustomerIdExits_shouldCreateAccountAndReturnAccountCreationResponse_hasNoTransaction() throws Exception {

        Customer customer = customerService.crateCustomer("FName", "SName");
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest(customer.getId(), BigDecimal.ZERO, AccountType.Current);

        this.mockMvc.perform(post(ACCOUNT_CREATE_API)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(accountCreationRequest)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.account.balance", is(0)))
                .andExpect(jsonPath("$.account.customer.firstName", is(customer.getFirstName())))
                .andExpect(jsonPath("$.account.customer.surname", is(customer.getSurname())))
                .andExpect(jsonPath("$.transaction", IsNull.nullValue()));
    }


}
