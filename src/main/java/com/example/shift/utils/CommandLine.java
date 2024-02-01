package com.example.shift.utils;

import com.lexicalscope.jewel.cli.Option;
import com.lexicalscope.jewel.cli.Unparsed;

import java.util.List;

public interface CommandLine {

    @Option(defaultValue = "", shortName = "o", description = "Path to output files")
    String getPathOutputFiles();

    @Option(defaultValue = "", shortName = "p", description = "Prefix to output files")
    String getPrefixOutputFiles();

    @Option(shortName = "a", description = "Append in output files")
    boolean getAppendOutputFiles();

    @Option(shortName = "s", description = "Short statistics")
    boolean getShortStatistics();

    @Option(shortName = "f", description = "Full statistics")
    boolean getFullStatistics();

    @Unparsed(defaultToNull = true)
    List<String> getFilesNames();
}

