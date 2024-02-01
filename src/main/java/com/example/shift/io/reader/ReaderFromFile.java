package com.example.shift.io.reader;

import com.example.shift.utils.CustomException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromFile implements Reader {
    private BufferedReader bufferedReader;

    @Override
    public void openInBufferedReader(String fileName) throws CustomException {
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            throw new CustomException("Unable to open inputfile " + fileName);
        }
    }

    @Override
    public void closeInBufferedReader() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Unable to close inputfile, skip it");
        }
    }

    @Override
    public String readFromBuffer() {
        try {
            String line;
            line = bufferedReader.readLine();
            return line;

        } catch (IOException e) {
            System.out.println("Unable to read from inputfile, skip it");
            return null;
        }
    }
}
