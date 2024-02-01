package com.example.shift.io.writer;

import com.example.shift.utils.CustomException;

public interface Writer {
    void openOutBufferedWriter(String fileName) throws CustomException;

    void writeToBuffer(String line);

    void closeOutBufferedWriter();
}
