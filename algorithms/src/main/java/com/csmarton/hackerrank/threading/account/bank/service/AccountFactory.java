package com.csmarton.hackerrank.threading.account.bank.service;

import com.csmarton.hackerrank.threading.account.bank.model.Account;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AccountFactory {

    private Account createAccount(String name, BigDecimal initialBalance) {
        return new Account(name, initialBalance);
    }

    public static Map<String, Account> createAccountsWithRandomBalance(int numOfAccount) {
        Map<String, Account> accounts = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < numOfAccount; i++) {
            String userName = "Account" + (i + 1);
            BigDecimal balance = new BigDecimal(random.nextDouble() * 100 + 100);
            balance = balance.setScale(0, RoundingMode.DOWN);
            Account account = new Account(userName, balance);
            accounts.put(userName, account);
        }

        return accounts;
    }

}
