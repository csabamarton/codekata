package com.csmarton.hackerrank.threading.account.banksys.service;

import com.csmarton.hackerrank.threading.account.banksys.model.Transaction;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TransactionExecutorService {

    public TransactionExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    private final ExecutorService executorService;

    public Future<Transaction> initiateTransfer(Transaction transaction) {
        TransactionCallable t = new TransactionCallable(transaction);

        Future<Transaction> future = executorService.submit(t);

        return future;
    }
}
