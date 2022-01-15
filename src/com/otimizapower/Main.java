package com.otimizapower;

import com.otimizapower.services.BankStatementCSVParser;
import com.otimizapower.services.BankTransactionAnalyzer;
import com.otimizapower.services.IBankStatementParser;

import java.io.IOException;
import java.time.Month;

public class Main {

    public static void main(String[] args) throws IOException {

        final BankTransactionAnalyzer bankTransactionAnalyzer = new BankTransactionAnalyzer();
        final IBankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankTransactionAnalyzer.execute("extrato.csv", bankStatementParser, Month.JANUARY);
    }
}
