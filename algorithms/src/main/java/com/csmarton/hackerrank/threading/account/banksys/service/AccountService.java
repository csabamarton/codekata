package com.csmarton.hackerrank.threading.account.banksys.service;

import com.csmarton.hackerrank.threading.account.banksys.model.Account;
import com.csmarton.hackerrank.threading.account.banksys.model.Transaction;
import com.csmarton.hackerrank.threading.account.banksys.model.TransactionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AccountService {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public List<Account> getAccounts() {
        return new ArrayList<>();
    }
}
