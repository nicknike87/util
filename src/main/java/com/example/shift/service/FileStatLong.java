package com.example.shift.service;

import com.example.shift.Solution;

public class FileStatLong implements FileStat {
    private long numberOfElements;
    private long maxValue = Long.MIN_VALUE;
    private long minValue = Long.MAX_VALUE;
    private long averageValue = 0;
    private long sumValue = 0;

    @Override
    public void calculateStatistics(String line) {
        if (Solution.ShortStatistics) {
            numberOfElements++;
        } else if (Solution.FullStatistics) {
            numberOfElements++;
            try {
                long val = Long.parseLong(line);
                if (maxValue < val) maxValue = val;
                if (minValue > val) minValue = val;
                sumValue += val;
                averageValue = sumValue / numberOfElements;
            } catch (NumberFormatException e) {
                System.out.println("Unable to parse to long value, skip it " + line);
            }
        }
    }

    @Override
    public void printStatistics() {
        if (numberOfElements > 0) {
            if (Solution.ShortStatistics) {
                System.out.println("\nShortStatistics on Integers:");
                System.out.printf("Number of elements is %d\n", numberOfElements);
            } else if (Solution.FullStatistics) {
                System.out.println("\nFullStatistics on Integers:");
                System.out.printf("Number of elements is %d\n", numberOfElements);
                System.out.printf("maxValue is %d\n", maxValue);
                System.out.printf("minValue is %d\n", minValue);
                System.out.printf("averageValue is %d\n", averageValue);
                System.out.printf("sumValue is %d\n", sumValue);
            }
        } else if (Solution.ShortStatistics || Solution.FullStatistics)
            System.out.println("There are no statistics on Floats because number of elements is zero");
    }
}
