package com.csmarton.hackerrank.threading.account.bank.service;

import com.csmarton.hackerrank.threading.account.bank.model.Account;
import com.csmarton.hackerrank.threading.account.bank.model.Transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class TransactionFactory {
    private final static Random generator = new Random();

    public static List<Transaction> createDummyTransactions(int numOfTransactions, Map<String, Account> accounts) {
        List<Account> values = accounts.values().stream().collect(Collectors.toList());

        List<Transaction> transactions = new ArrayList<>();

        for (int i = 0; i < numOfTransactions; i++) {
            transactions.add(createTransaction(values));
        }

        return transactions;
    }

    private static Transaction createTransaction(List<Account> values) {
        Account fromAccount = values.get(generator.nextInt(values.size()));
        Account toAccount = fromAccount;

        while (fromAccount != toAccount) {
            fromAccount = values.get(generator.nextInt(values.size()));
        }

        double amount = new Random().nextDouble() * 50 + 150;
        return new Transaction(fromAccount, toAccount, new BigDecimal(amount).setScale(0, RoundingMode.DOWN));
    }
}
