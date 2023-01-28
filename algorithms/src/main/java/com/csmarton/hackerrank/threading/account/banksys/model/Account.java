package com.csmarton.hackerrank.threading.account.banksys.model;

import lombok.Getter;

import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
public class Account {
    private String name;
    private double balance;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        lock.writeLock().lock();
        try {
            if (this.getBalance() < amount) {
                System.out.println(String.format("Not enough credit on the this user's (%s) account for making this transaction: %.0f, Balance: %.0f", name, amount, balance));
                return false;
            }

            System.out.println(String.format("Has enough credit on the this user's (%s) account for making this transaction: %.0f, Balance: %.0f", name, amount, balance));

            balance -= amount;

            return true;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean deposit(double amount) {

        lock.writeLock().lock();
        try {
            balance += amount;
            return true;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public double getBalance() {
        lock.readLock().lock();
        try {
            return balance;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
