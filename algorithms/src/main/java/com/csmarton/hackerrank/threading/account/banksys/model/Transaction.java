package com.csmarton.hackerrank.threading.account.banksys.model;

import lombok.Getter;

@Getter
public class Transaction {
    private Account sender;
    private Account reciever;

    private double amount;

    private TransactionStatus status;

    public Transaction(Account sender, Account reciever, double amount) {
        this.sender = sender;
        this.reciever = reciever;
        this.amount = amount;
        this.status = TransactionStatus.INIT;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
