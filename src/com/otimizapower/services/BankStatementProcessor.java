package com.otimizapower.services;

import com.otimizapower.entities.BankTransaction;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    private BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public static BankStatementProcessor newInstance(final List<BankTransaction> bankTransactions) {
        return new BankStatementProcessor(bankTransactions);
    }

    public double getTotalAllTransaction() {
        return this.bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double getTotalInMonth(final Month month) {
        return this.bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.getDate().getMonth().equals(month))
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }
}
