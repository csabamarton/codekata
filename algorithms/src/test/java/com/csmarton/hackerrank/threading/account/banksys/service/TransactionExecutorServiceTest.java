package com.csmarton.hackerrank.threading.account.banksys.service;

import com.csmarton.hackerrank.threading.account.banksys.model.Transaction;
import com.csmarton.hackerrank.threading.account.banksys.model.Account;
import com.csmarton.hackerrank.threading.account.banksys.model.TransactionStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionExecutorServiceTest {

    private TransactionExecutorService transactionExecutorService;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @BeforeEach
    void setUp() {
        transactionExecutorService = new TransactionExecutorService(executorService);
    }

    @AfterEach
    void tearDown() {
        executorService.shutdown();
    }

    @Test
    void testOneTransactionWithNotEnoughCredit() throws ExecutionException, InterruptedException {
        Account accountA = new Account("Csaba", 100);
        Account accountB = new Account("Peter", 200);

        Transaction transaction = new Transaction(accountA, accountB, 200);

        Future<Transaction> transactionFuture = transactionExecutorService.initiateTransfer(transaction);

        assertEquals(transactionFuture.get().getStatus(), TransactionStatus.FAILED_NO_CREDIT);
        assertEquals(accountA.getBalance(), 100);
        assertEquals(accountB.getBalance(), 200);

    }

    @Test
    void testOneTransactionWithEnoughCredit() throws ExecutionException, InterruptedException {
        Account accountA = new Account("Csaba", 100);
        Account accountB = new Account("Peter", 200);

        Transaction transaction = new Transaction(accountA, accountB, 50);

        Future<Transaction> transactionFuture = transactionExecutorService.initiateTransfer(transaction);

        assertEquals(transactionFuture.get().getStatus(), TransactionStatus.SUCCESS);
        assertEquals(accountA.getBalance(), 50);
        assertEquals(accountB.getBalance(), 250);

    }

    @Test
    void testTwoTransactionWithNotEnoughCredit() throws ExecutionException, InterruptedException {
        Account accountA = new Account("Csaba", 100);
        Account accountB = new Account("Peter", 200);

        Transaction transaction = new Transaction(accountA, accountB, 80);
        Transaction transaction2 = new Transaction(accountA, accountB, 100);

        Future<Transaction> transactionFuture = transactionExecutorService.initiateTransfer(transaction);
        Future<Transaction> transactionFuture2 = transactionExecutorService.initiateTransfer(transaction2);

        assertEquals(transactionFuture.get().getStatus(), TransactionStatus.SUCCESS);
        assertEquals(transactionFuture2.get().getStatus(), TransactionStatus.FAILED_NO_CREDIT);
        assertEquals(accountA.getBalance(), 20);
        assertEquals(accountB.getBalance(), 280);
    }
}