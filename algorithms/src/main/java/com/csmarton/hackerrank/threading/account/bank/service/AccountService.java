package com.csmarton.hackerrank.threading.account.bank.service;

import com.csmarton.hackerrank.threading.account.bank.model.Account;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountService {

    private Map<String, Account> accounts;

    public AccountService() {
    }

    public void setAccounts(int numofAccounts) {
        accounts = AccountFactory.createAccountsWithRandomBalance(numofAccounts);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public BigDecimal getSumOfBalances() {
        return accounts.values().stream().map(v -> v.getBalance()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
