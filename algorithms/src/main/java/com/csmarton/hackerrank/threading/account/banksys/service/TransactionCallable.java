package com.csmarton.hackerrank.threading.account.banksys.service;

import com.csmarton.hackerrank.threading.account.banksys.model.Transaction;
import com.csmarton.hackerrank.threading.account.banksys.model.TransactionStatus;

import java.util.concurrent.Callable;

public class TransactionCallable implements Callable {

    AccountService accountService;
    public TransactionCallable(Transaction transaction, AccountService accountService) {
        this.transaction = transaction;
        this.accountService = accountService;
    }

    private final Transaction transaction;
    @Override
    public Transaction call() throws Exception {
        Transaction transactionResult = accountService.transferMoney(transaction);

        boolean withdrawResult = transaction.getSender().withdraw(transaction.getAmount());
        if (!withdrawResult) {
            transaction.setStatus(TransactionStatus.FAILED_NO_CREDIT);
            return transaction;
        }

        boolean depositResult = transaction.getReciever().deposit(transaction.getAmount());

        transaction.setStatus(TransactionStatus.SUCCESS);

        return transaction;
    }
}
