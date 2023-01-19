package com.csmarton.hackerrank.threading.account.sharedaccont;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

public class SharedAccountApp {

    public static void main(String[] args) {
        SharedAccount account = new SharedAccount(new BigDecimal("100"));

        account.withdrawal(new BigDecimal(20), "Adam");
        account.withdrawal(new BigDecimal(130), "Anna");
        account.withdrawal(new BigDecimal(60), "Peter");

        System.out.println("End");

        BankAccount bankAccount = new BankAccount(new BigDecimal("100"));


        ThreadWithdrawal t1 = new ThreadWithdrawal(bankAccount, "Adam", new BigDecimal(20));
        ThreadWithdrawal t2 = new ThreadWithdrawal(bankAccount, "Anna", new BigDecimal(130));
        ThreadWithdrawal t3 = new ThreadWithdrawal(bankAccount, "Peter", new BigDecimal(60));

        t1.start();
        t2.start();
        t3.start();

        System.out.println("End");
    }
}

class ThreadDeposit extends Thread {
        private BankAccount bank;
        private String name;
        private BigDecimal dollar;

        public void run() {
            this.bank.deposit(dollar, name);
        }
    }

