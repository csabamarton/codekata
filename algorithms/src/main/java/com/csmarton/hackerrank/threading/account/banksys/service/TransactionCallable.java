package com.csmarton.hackerrank.threading.account.banksys.service;

import com.csmarton.hackerrank.threading.account.banksys.model.Transaction;

import java.util.concurrent.Callable;

public class TransactionCallable implements Callable {

    public TransactionCallable(Transaction transaction) {
        this.transaction = transaction;
    }

    private final Transaction transaction;
    @Override
    public String call() throws Exception {
        return null;
    }
}
