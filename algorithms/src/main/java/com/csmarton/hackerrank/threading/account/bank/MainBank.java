package com.csmarton.hackerrank.threading.account.bank;

import com.csmarton.hackerrank.threading.account.bank.model.Account;
import com.csmarton.hackerrank.threading.account.bank.model.Transaction;
import com.csmarton.hackerrank.threading.account.bank.service.AccountService;
import com.csmarton.hackerrank.threading.account.bank.service.TransactionFactory;
import com.csmarton.hackerrank.threading.account.bank.service.TransactionService;

import java.util.List;
import java.util.Map;

public class MainBank {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();

        int numOfAccounts = 5;
        int numofTransactions = 10;

        accountService.setAccounts(numOfAccounts);

        System.out.println("Sum of Balances before transactions: " + accountService.getSumOfBalances());

        List<Transaction> transactions = TransactionFactory.createDummyTransactions(10, accountService.getAccounts());

        for (int i = 0; i < numofTransactions; i++) {
            transactionService.transfer(transactions.get(i));
        }

        System.out.println("Sum of Balances after transactions: " + accountService.getSumOfBalances());

    }
}
