package com.csmarton.hackerrank.threading.account.sharedaccont;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class ThreadWithdrawal extends Thread {
    private BankAccount bank;
    private String name;
    private BigDecimal dollar;

    public void run() {
        this.bank.withdrawal(dollar, name);
    }
}
