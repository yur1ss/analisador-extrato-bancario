package com.otimizapower.analizadorextratobancario.services;

import com.otimizapower.analizadorextratobancario.entities.BankTransaction;
import com.otimizapower.analizadorextratobancario.entities.SummaryStatistics;

import java.time.Month;
import java.util.DoubleSummaryStatistics;
import java.util.List;

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
        return this.bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.getAmount() >= amount)
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double findTransactionGreaterThanEqualInMonth(final Double amount, final Month month) {
        return this.bankTransactions.stream()
                .filter(bankTransaction ->
                        bankTransaction.getAmount() >= amount && bankTransaction.getDate().getMonth().equals(month))
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public SummaryStatistics summarizeTransactions() {
        final DoubleSummaryStatistics doubleSummaryStatistics = bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .summaryStatistics();

        return SummaryStatistics.newInstance(doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getAverage());
    }
}
