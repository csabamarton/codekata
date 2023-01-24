package com.csmarton.hackerrank.threading.account.banksys.service;

import com.csmarton.hackerrank.threading.account.banksys.model.Transaction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TransactionExecutorService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void initiateTransfer(Transaction transaction) {
        TransactionCallable t = new TransactionCallable(transaction);

        Future<String> transactionFuture = executorService.submit(t);


    }
}
