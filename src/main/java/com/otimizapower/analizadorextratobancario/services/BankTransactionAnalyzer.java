package com.otimizapower.analizadorextratobancario.services;

import com.otimizapower.analizadorextratobancario.entities.BankTransaction;
import com.otimizapower.analizadorextratobancario.entities.SummaryStatistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public BankTransactionAnalyzer() {
        // TODO document why this constructor is empty
    }

    public void execute(final String fileName,
                        final IBankStatementParser bankStatementParser,
                        final Month month,
                        final IExporter exporter) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = BankStatementProcessor.newInstance(bankTransactions);
        final SummaryStatistics summaryStatistics = bankStatementProcessor.summarizeTransactions();

        collectSummary(bankStatementProcessor, month, exporter.exporter(summaryStatistics));
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor,
                                       final Month month,
                                       final String exporter) {
        System.out.println("Total de transações: R$ " + bankStatementProcessor.sumTotalTransaction());
        System.out.println("Total de transações do mes de " + month.name() + " : R$ "  + bankStatementProcessor.findTotalTransactionInMonth(month));
        System.out.println(exporter);
    }
}
