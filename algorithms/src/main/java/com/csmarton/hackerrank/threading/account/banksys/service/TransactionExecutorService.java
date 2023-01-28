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
        Callable callable = new Callable() {
            @Override
            public Transaction call() throws Exception {
                Account sender = transaction.getSender();
                Account reciever = transaction.getReciever();

                boolean withdrawResult = sender.withdraw(transaction.getAmount();

                if (!withdrawResult) {
                    transaction.setStatus(TransactionStatus.FAILED_NO_CREDIT);
                    return transaction;
                }
                boolean depositResult = reciever.deposit(transaction.getAmount());

                transaction.setStatus(TransactionStatus.SUCCESS);
                accountService.saveTransaction(transaction);

            }
        }

        Future<Transaction> future = executorService.submit(callable);

        return future;
    }
}
