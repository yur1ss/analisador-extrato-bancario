package com.otimizapower.analizadorextratobancario;

import com.otimizapower.analizadorextratobancario.services.BankStatementCSVParser;
import com.otimizapower.analizadorextratobancario.services.BankTransactionAnalyzer;
import com.otimizapower.analizadorextratobancario.services.HtmlReport;
import com.otimizapower.analizadorextratobancario.services.IBankStatementParser;
import com.otimizapower.analizadorextratobancario.services.IExporter;

import java.io.IOException;
import java.time.Month;

public class Main {

    public static void main(String[] args) throws IOException {

        final BankTransactionAnalyzer bankTransactionAnalyzer = new BankTransactionAnalyzer();
        final IBankStatementParser bankStatementParser = new BankStatementCSVParser();
        final IExporter htmlReport = new HtmlReport();

        bankTransactionAnalyzer.execute("extrato.csv", bankStatementParser, Month.JANUARY, htmlReport);
    }
}
