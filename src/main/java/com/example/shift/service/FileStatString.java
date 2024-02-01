package com.example.shift.service;

import com.example.shift.Solution;

public class FileStatString implements FileStat {
    private long numberOfElements;
    private long longestString = Long.MIN_VALUE;
    private long shortestString = Long.MAX_VALUE;

    @Override
    public void calculateStatistics(String line) {
        if (Solution.ShortStatistics) {
            numberOfElements++;
        } else if (Solution.FullStatistics) {
            numberOfElements++;
            long len = line.length();
            if (longestString < len) longestString = len;
            if (shortestString > len) shortestString = len;
        }
    }

    @Override
    public void printStatistics() {
        if (numberOfElements > 0) {
            if (Solution.ShortStatistics) {
                System.out.println("\nShortStatistics on Strings:");
                System.out.printf("Number of elements is %d\n", numberOfElements);
            } else if (Solution.FullStatistics) {
                System.out.println("\nFullStatistics on Strings:");
                System.out.printf("Number of elements is %d\n", numberOfElements);
                System.out.printf("longestString is %d\n", longestString);
                System.out.printf("shortestString is %d\n", shortestString);
            }
        } else if (Solution.ShortStatistics || Solution.FullStatistics)
            System.out.println("There are no statistics on Floats because number of elements is zero");
    }
}
