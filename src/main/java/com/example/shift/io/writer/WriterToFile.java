package com.example.shift.io.writer;

import com.example.shift.Solution;
import com.example.shift.utils.CustomException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.shift.utils.Utils.deleteFileIfExists;
import static com.example.shift.utils.Utils.getAbsolutePath;

public class WriterToFile implements Writer {
    private BufferedWriter outBufferedWriter;

    @Override
    public void openOutBufferedWriter(String fileName) throws CustomException {

        fileName = getAbsolutePath(fileName);

        if (!Solution.AppendOutputFiles) {
            if (!deleteFileIfExists(fileName)) {
                System.out.println("Unable to delete existing outputfile, skip it " + fileName);
            }
        }

        try {
            outBufferedWriter = new BufferedWriter(new FileWriter(fileName, true));

        } catch (IOException e) {
            throw new CustomException("Unable to open outputfile " + fileName);
        }
    }

    @Override
    public void writeToBuffer(String line) {
        try {
            outBufferedWriter.write(line);
            outBufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println("Unable to write into outputfile value, skip it " + line);
        }
    }

    @Override
    public void closeOutBufferedWriter() {
        try {
            outBufferedWriter.flush();
            outBufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Unable to close outputfile, skip it");
        }
    }


}
