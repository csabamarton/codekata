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


    public Transaction transferMoney(Transaction transaction) {

        Account sender = transaction.getSender();
        Account reciever = transaction.getReciever();

        boolean withdrawResult = sender.withdraw(transaction.getAmount();

        if (!withdrawResult) {
            transaction.setStatus(TransactionStatus.FAILED_NO_CREDIT);
            return transaction;
        }
        boolean depositResult = reciever.deposit(transaction.getAmount());

        transaction.setStatus(TransactionStatus.SUCCESS);

        saveTransaction(transaction);

        return transaction;
    }


    private boolean withdraw(Account account, double amount) {
        account.getLock().writeLock().lock();
        try {
            if (account.getBalance() < amount) {
                System.out.println(String.format("Not enough credit on the this user's (%s) account for making this transaction: %.0f, Balance: %.0f", name, amount, balance));
                return false;
            }

            System.out.println(String.format("Has enough credit on the this user's (%s) account for making this transaction: %.0f, Balance: %.0f", name, amount, balance));

            account.setBalance(); -= amount;

            //writeOut account balance change to presistence
            return true;
        } finally {
            lock.writeLock().unlock();
        }
    }

    private boolean deposit(Account account, double amount) {

        lock.writeLock().lock();
        try {
            account.setBalance(account.getBalance() + amount);
            //writeOut account balance change to presistence
            return true;
        } finally {
            lock.writeLock().unlock();
        }
    }

    private boolean saveTransaction(Transaction transaction) {

    }
}
