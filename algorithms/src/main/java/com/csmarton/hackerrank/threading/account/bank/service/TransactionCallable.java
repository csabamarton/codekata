package com.csmarton.hackerrank.threading.account.bank.service;

import com.csmarton.hackerrank.threading.account.bank.model.Account;
import com.csmarton.hackerrank.threading.account.bank.model.Transaction;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class TransactionCallable implements Callable<String> {

    public TransactionCallable(Transaction transaction) {
        this.transaction = transaction;
    }

    private final Transaction transaction;

    private void transfer() {
        boolean resultOfWithdrawal = transaction.getSenderAccount().withdrawl(transaction.getAmount());
        if(!resultOfWithdrawal) {
            System.out.println(String.format(
                    "Not enough money from this %.0f amount of transaction : %s (Sender), %.0f (balance)",
                    transaction.getAmount(), transaction.getSenderAccount().getUserName(), transaction.getSenderAccount().getBalance()));
            return;
        } else
            System.out.println(String.format(
                    "There is enough money from this %.0f amount of transaction : %s (Sender), %.0f (balance)",
                    transaction.getAmount(), transaction.getSenderAccount().getUserName(), transaction.getSenderAccount().getBalance()));

        transaction.getRecieverAccount().deposit(transaction.getAmount());
    }

    @Override
    public String call() throws Exception {
        this.transfer();

        return "Transfer Done";
    }
}


