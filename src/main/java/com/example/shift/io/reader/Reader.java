package com.example.shift.io.reader;

import com.example.shift.utils.CustomException;

public interface Reader {
    void openInBufferedReader(String fileName) throws CustomException;

    void closeInBufferedReader();

    String readFromBuffer();
}
