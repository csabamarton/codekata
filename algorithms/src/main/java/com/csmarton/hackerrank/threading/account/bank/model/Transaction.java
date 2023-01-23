package com.csmarton.hackerrank.threading.account.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Transaction {
    private final Account senderAccount;
    private final Account recieverAccount;
    private final BigDecimal amount;

}
