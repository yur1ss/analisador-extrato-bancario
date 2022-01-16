package com.otimizapower.analizadorextratobancario.services;

import com.otimizapower.analizadorextratobancario.entities.BankTransaction;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    private BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public static BankStatementProcessor newInstance(final List<BankTransaction> bankTransactions) {
        return new BankStatementProcessor(bankTransactions);
    }

    public double sumTotalTransaction() {
        return this.bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double findTotalTransactionInMonth(final Month month) {
        return this.bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.getDate().getMonth().equals(month))
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double findTransactionGreaterThanEqual(final Double amount) {
        return this.findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount).stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double findTransactionGreaterThanEqualInMonth(final Double amount, final Month month) {
        return this.findTransactions(bankTransaction ->
                        bankTransaction.getAmount() >= amount && bankTransaction.getDate().getMonth().equals(month))
                .stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    private List<BankTransaction> findTransactions(final IBankTransactionFilter bankTransactionFilter) {
        return this.bankTransactions.stream()
                .filter(bankTransactionFilter::test)
                .collect(Collectors.toUnmodifiableList());
    }
}
