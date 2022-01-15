package com.otimizapower.analizadorextratobancario.services;

import com.otimizapower.analizadorextratobancario.entities.BankTransaction;

import java.util.List;

public interface IBankStatementParser {
    List<BankTransaction> parseLinesFrom(List<String> lines);
    BankTransaction parseFrom(String line);
}
