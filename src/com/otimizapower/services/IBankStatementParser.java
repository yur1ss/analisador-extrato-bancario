package com.otimizapower.services;

import com.otimizapower.entities.BankTransaction;

import java.util.List;

public interface IBankStatementParser {
    List<BankTransaction> parseLinesFrom(List<String> lines);
    BankTransaction parseFrom(String line);
}
