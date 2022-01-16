package com.otimizapower.analizadorextratobancario.services;

import com.otimizapower.analizadorextratobancario.entities.SummaryStatistics;

public interface IExporter {
    String exporter(SummaryStatistics summaryStatistics);
}
