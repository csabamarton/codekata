package com.csmarton.hackerrank.threading.account.bank.model;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AllArgsConstructor
public final class Account {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final String userName;
    private BigDecimal balance;

    public BigDecimal getBalance() {
        try {
            lock.readLock().lock();

            return balance;
        } finally {
            lock.readLock().unlock();
        }
    }

    public String getUserName() {
        return userName;
    }

    public void deposit(BigDecimal amount) {
        try {
            lock.writeLock().lock();
            balance.add(amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean withdrawl(BigDecimal amount) {
        try {
            lock.writeLock().lock();
            if(amount.compareTo(balance) != 1) {
                balance.subtract(amount);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return  true;
            } else
                return false;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
