package com.example.shift;

import com.example.shift.service.Sorter;
import com.example.shift.utils.CommandLineParser;

public class Solution {
    public static String PathOutputFiles;
    public static String PrefixOutputFiles;
    public static boolean AppendOutputFiles;
    public static boolean ShortStatistics;
    public static boolean FullStatistics;
    public static final String NAME_DEFAULT_INTEGERS = "integers.txt";
    public static final String NAME_DEFAULT_FLOATS = "floats.txt";
    public static final String NAME_DEFAULT_STRINGS = "strings.txt";

    public static void main(String[] args) {
        try {
            Sorter sorter = new Sorter.Builder()
                    .commandLineParser(new CommandLineParser(args))
                    .addInputFileNames()
                    .build();
            sorter.start();

            System.out.println("Processing completed successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
