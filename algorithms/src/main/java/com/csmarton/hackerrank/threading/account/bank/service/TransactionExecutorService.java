package com.csmarton.hackerrank.threading.account.bank.service;

import com.csmarton.hackerrank.threading.account.bank.model.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TransactionExecutorService {

    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public void initiateTransfers(List<Transaction> transactions) throws ExecutionException, InterruptedException {
        List<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < transactions.size(); i++) {
            TransactionCallable t = new TransactionCallable(transactions.get(i));
            results.add(executor.submit(t));
        }

        boolean hasUnfinished = true;

        while (hasUnfinished) {
            hasUnfinished = false;
            Iterator<Future<String>> iterator = results.iterator();
            while (iterator.hasNext()) {
                Future<String> future = iterator.next();
                if(future.isDone()) {
                    System.out.println(future.get());
                    iterator.remove();
                } else
                    hasUnfinished = true;
            }
        }

        executor.shutdown();

        System.out.println("Finish");
    }
}
