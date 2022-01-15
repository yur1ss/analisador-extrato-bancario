package com.otimizapower.analizadorextratobancario.services;

import com.otimizapower.analizadorextratobancario.entities.BankTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

class BankStatementProcessorTest {
    private final BankTransaction bankTransaction1 = BankTransaction.newInstance(
            LocalDate.of(2022, Month.JANUARY, 15), 1000d, "salary");
    private final BankTransaction bankTransaction2 = BankTransaction.newInstance(
            LocalDate.of(2022, Month.FEBRUARY, 16), -100d, "food");

    private final List<BankTransaction> bankStatement = List.of(bankTransaction1, bankTransaction2);
    private final BankStatementProcessor bankStatementProcessor = BankStatementProcessor.newInstance(bankStatement);

    @Test
    void deveAnalisarSeOTotalDasTransacoesEstaCorreto() {
        final double result = bankStatementProcessor.getTotalAllTransaction();
        final double expected = 900d;

        Assertions.assertEquals(expected, result, 0.0d);
    }

    @Test
    void deveAnalisarSeOTotalDoMesDeJaneiroEstaCorreto() {
        final double result = bankStatementProcessor.getTotalInMonth(Month.JANUARY);
        final double expected = 1000d;

        Assertions.assertEquals(expected, result);
    }
}
