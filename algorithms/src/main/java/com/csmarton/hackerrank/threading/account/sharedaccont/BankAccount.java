package com.csmarton.hackerrank.threading.account.sharedaccont;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

public class BankAccount {

    private BigDecimal balance;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }


    void deposit(BigDecimal amount, String name) {
        balance = balance.add(amount);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("New deposit in the account by %s: %.0f. New balance: %.0f", name, amount, balance));
    }

    void withdrawal(BigDecimal amount, String name) {
        if(balance.compareTo(amount) == -1) {
            System.out.println("There is no enough money for this transaction: ");
        } else {
            balance = balance.subtract(amount);
            System.out.println(String.format("Withdraw from the account by %s: %.0f. New balance: %.0f", name, amount, balance));
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
