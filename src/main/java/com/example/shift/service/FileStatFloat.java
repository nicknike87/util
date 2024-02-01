package com.example.shift.service;

import com.example.shift.Solution;

public class FileStatFloat implements FileStat {
    private long numberOfElements;
    private double maxValue = Double.MIN_VALUE;
    private double minValue = Double.MAX_VALUE;
    private double averageValue = 0;
    private double sumValue = 0;

    @Override
    public void calculateStatistics(String line) {
        if (Solution.ShortStatistics) {
            numberOfElements++;
        } else if (Solution.FullStatistics) {
            numberOfElements++;
            try {
                double val = Double.parseDouble(line);
                if (maxValue < val) maxValue = val;
                if (minValue > val) minValue = val;
                sumValue += val;
                averageValue = sumValue / numberOfElements;
            } catch (NumberFormatException e) {
                System.out.println("Unable to parse to double value, skip it " + line);
            }
        }
    }

    @Override
    public void printStatistics() {
        if (numberOfElements > 0) {
            if (Solution.ShortStatistics) {
                System.out.println("\nShortStatistics on Float:");
                System.out.printf("Number of elements is %d\n", numberOfElements);
            } else if (Solution.FullStatistics) {
                System.out.println("\nFullStatistics on Float:");
                System.out.printf("Number of elements is %d\n", numberOfElements);
                System.out.printf("maxValue is %f\n", maxValue);
                System.out.printf("minValue is %f\n", minValue);
                System.out.printf("averageValue is %f\n", averageValue);
                System.out.printf("sumValue is %f\n", sumValue);
            }
        } else if (Solution.ShortStatistics || Solution.FullStatistics)
            System.out.println("There are no statistics on Floats because number of elements is zero");
    }
}


