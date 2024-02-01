package com.example.shift.utils;

import com.example.shift.Solution;
import com.lexicalscope.jewel.cli.ArgumentValidationException;
import com.lexicalscope.jewel.cli.CliFactory;

import java.util.Arrays;

public class CommandLineParser {

    private final CommandLine commandLine;

    public CommandLineParser(final String[] commandLineArguments) throws CustomException {

        commandLine = parseCommandLine(commandLineArguments);
        if (commandLine == null) {
            throw new CustomException("Failed to process input parameters.");
        } else {
            validateCommandLine(commandLine);
        }
    }

    public CommandLine getCommandLine() {
        return commandLine;
    }

    private CommandLine parseCommandLine(final String[] commandLineArguments) throws CustomException {

        CommandLine commandLine = null;
        try {
            commandLine = CliFactory.parseArguments(CommandLine.class, commandLineArguments);
        } catch (ArgumentValidationException e) {
            throw new CustomException("ERROR: Unable to parse command-line arguments "
                    + Arrays.toString(commandLineArguments) + " due to: "
                    + e.getValidationFailures() + " , Fix it please...");
        }
        return commandLine;
    }

    private void validateCommandLine(CommandLine commandLine) throws CustomException {

        if (commandLine.getFilesNames().size() < 1) {
            throw new CustomException("At least one input filename must be entered, Fix it please...");
        }
        if (commandLine.getShortStatistics() && commandLine.getFullStatistics()) {
            throw new CustomException("You have entered both mutually exclusive parameters -s -f, Fix it please...");
        }
        Solution.PathOutputFiles = commandLine.getPathOutputFiles();
        Solution.PrefixOutputFiles = commandLine.getPrefixOutputFiles();
        Solution.AppendOutputFiles = commandLine.getAppendOutputFiles();
        Solution.ShortStatistics = commandLine.getShortStatistics();
        Solution.FullStatistics = commandLine.getFullStatistics();

    }
}
