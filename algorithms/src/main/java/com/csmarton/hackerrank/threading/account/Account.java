package com.csmarton.hackerrank.threading.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class Account {

    private BigDecimal balance;
    private String userId;
    private String accountNumber;

    public void transfer(Account from, Account to, BigDecimal amount) {

    }

}
