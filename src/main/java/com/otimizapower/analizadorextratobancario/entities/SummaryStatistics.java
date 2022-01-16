package com.otimizapower.analizadorextratobancario.entities;

public class SummaryStatistics {
    private final double sum;
    private final double max;
    private final double min;
    private final double average;

    private SummaryStatistics(double sum, double max, double min, double average) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
    }

    public static SummaryStatistics newInstance(final double sum, final double max, final double min, final double average) {
        return new SummaryStatistics(sum, max, min, average);
    }

    public double getSum() {
        return sum;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }
}
