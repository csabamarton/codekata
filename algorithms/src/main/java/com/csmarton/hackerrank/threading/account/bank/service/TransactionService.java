package com.csmarton.hackerrank.threading.account.bank.service;

import com.csmarton.hackerrank.threading.account.bank.model.Account;
import com.csmarton.hackerrank.threading.account.bank.model.Transaction;

import java.math.BigDecimal;

public class TransactionService {

    public void transfer(Transaction transaction) {
        if(transaction.getAmount().compareTo(transaction.getSenderAccount().getBalance()) == 1) {
            System.out.println(String.format(
                    "Not enough money from this %.0f amount of transaction : %s (Sender), %.0f (balance)",
                    transaction.getAmount(), transaction.getSenderAccount().getUserName(), transaction.getSenderAccount().getBalance()));
            return ;
        }

        withdrawl(transaction.getSenderAccount(), transaction.getAmount());
        deposit(transaction.getRecieverAccount(), transaction.getAmount());
    }

    private void deposit(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
    }

    private void withdrawl(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().subtract(amount));
    }

}
