package com.csmarton.hackerrank.threading.account.bank;

import com.csmarton.hackerrank.threading.account.bank.model.Transaction;
import com.csmarton.hackerrank.threading.account.bank.service.AccountService;
import com.csmarton.hackerrank.threading.account.bank.service.TransactionFactory;
import com.csmarton.hackerrank.threading.account.bank.service.TransactionExecutorService;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainBank {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AccountService accountService = new AccountService();
        TransactionExecutorService transactionService = new TransactionExecutorService();

        int numOfAccounts = 2;

        accountService.setAccounts(numOfAccounts);

        System.out.println("Sum of Balances before transactions: " + accountService.getSumOfBalances());

        List<Transaction> transactions = TransactionFactory.createDummyTransactions(10, accountService.getAccounts());

        System.out.println(transactions);
        transactionService.initiateTransfers(transactions);

        System.out.println("Sum of Balances after transactions: " + accountService.getSumOfBalances());
    }
}
