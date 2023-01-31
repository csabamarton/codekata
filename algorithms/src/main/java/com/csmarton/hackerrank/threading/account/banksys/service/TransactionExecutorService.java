package com.csmarton.hackerrank.threading.account.banksys.service;

import com.csmarton.hackerrank.threading.account.banksys.model.Account;
import com.csmarton.hackerrank.threading.account.banksys.model.Transaction;
import com.csmarton.hackerrank.threading.account.banksys.model.TransactionStatus;

import java.util.concurrent.*;

public class TransactionExecutorService {

    public TransactionExecutorService(ExecutorService executorService, AccountService accountService) {
        this.executorService = executorService;
        this.accountService = accountService;
    }

    private final ExecutorService executorService;
    private final AccountService accountService;

    public Future<Transaction> initiateTransfer(Transaction transaction) {
        TransactionCallable callable = new TransactionCallable(transaction, accountService);

        Future<Transaction> future = executorService.submit(callable);

        return future;
    }
}
