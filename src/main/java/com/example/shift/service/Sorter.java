package com.example.shift.service;

import com.example.shift.Solution;
import com.example.shift.io.reader.Reader;
import com.example.shift.io.reader.ReaderFromFile;
import com.example.shift.io.writer.WriterToFile;
import com.example.shift.utils.CommandLineParser;

import java.util.ArrayList;
import java.util.List;

import static com.example.shift.utils.Utils.isFloat;
import static com.example.shift.utils.Utils.isNumeric;

public class Sorter {
    private final List<String> inputFileNames = new ArrayList<>();
    private WriterFileStat writerFileStatLong, writerFileStatFloat, writerFileStatString;
    private Reader readerFromFile;

    public void start() throws Exception {
        String line;
        readerFromFile = new ReaderFromFile();

        for (String el : inputFileNames) {
            readerFromFile.openInBufferedReader(el);
            while ((line = readerFromFile.readFromBuffer()) != null) {
                writeLineIntoFile(line);
            }
            readerFromFile.closeInBufferedReader();
        }
        printStatisticsInConsole();
        closeAllWriterFileStat();
    }

    private void writeLineIntoFile(String line) throws Exception {

        if (isNumeric(line)) {
            if (writerFileStatLong == null) {
                writerFileStatLong = new WriterFileStat(new WriterToFile(), new FileStatLong());
                writerFileStatLong.getWriterToFile().openOutBufferedWriter(Solution.PathOutputFiles + "/" +
                        Solution.PrefixOutputFiles +
                        Solution.NAME_DEFAULT_INTEGERS);
            }
            writerFileStatLong.getWriterToFile().writeToBuffer(line);
            writerFileStatLong.getFileStat().calculateStatistics(line);

        } else if (isFloat(line)) {

            if (writerFileStatFloat == null) {
                writerFileStatFloat = new WriterFileStat(new WriterToFile(), new FileStatFloat());
                writerFileStatFloat.getWriterToFile().openOutBufferedWriter(Solution.PathOutputFiles + "/" +
                        Solution.PrefixOutputFiles +
                        Solution.NAME_DEFAULT_FLOATS);
            }
            writerFileStatFloat.getWriterToFile().writeToBuffer(line);
            writerFileStatFloat.getFileStat().calculateStatistics(line);

        } else {

            if (writerFileStatString == null) {
                writerFileStatString = new WriterFileStat(new WriterToFile(), new FileStatString());
                writerFileStatString.getWriterToFile().openOutBufferedWriter(Solution.PathOutputFiles + "/" +
                        Solution.PrefixOutputFiles +
                        Solution.NAME_DEFAULT_STRINGS);
            }
            writerFileStatString.getWriterToFile().writeToBuffer(line);
            writerFileStatString.getFileStat().calculateStatistics(line);
        }
    }

    private void printStatisticsInConsole() {
        if (writerFileStatLong != null) writerFileStatLong.getFileStat().printStatistics();
        if (writerFileStatFloat != null) writerFileStatFloat.getFileStat().printStatistics();
        if (writerFileStatString != null) writerFileStatString.getFileStat().printStatistics();
    }

    private void closeAllWriterFileStat() {
        if (writerFileStatLong != null) writerFileStatLong.getWriterToFile().closeOutBufferedWriter();
        if (writerFileStatFloat != null) writerFileStatFloat.getWriterToFile().closeOutBufferedWriter();
        if (writerFileStatString != null) writerFileStatString.getWriterToFile().closeOutBufferedWriter();
    }

    private Sorter(Builder builder) {
        if (builder != null) {
            inputFileNames.addAll(builder.inputFileNames);
        }
    }

    public static class Builder {
        private CommandLineParser commandLineParser;
        private final List<String> inputFileNames = new ArrayList<>();

        public Builder commandLineParser(CommandLineParser commandLineParser) {
            this.commandLineParser = commandLineParser;
            return this;
        }

        public Builder addInputFileNames() {
            this.inputFileNames.addAll(new ArrayList<>(this.commandLineParser.getCommandLine().getFilesNames()));
            return this;
        }

        public Sorter build() {
            return new Sorter(this);
        }
    }
}
