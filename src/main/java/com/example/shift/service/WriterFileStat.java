package com.example.shift.service;

import com.example.shift.io.writer.Writer;
import com.example.shift.io.writer.WriterToFile;

public class WriterFileStat {

    private Writer writerToFile;
    private FileStat fileStat;

    public WriterFileStat(WriterToFile writerToFile, FileStat fileStat) {
        this.writerToFile = writerToFile;
        this.fileStat = fileStat;
    }

    public Writer getWriterToFile() {
        return writerToFile;
    }

    public void setWriterToFile(Writer writerToFile) {
        this.writerToFile = writerToFile;
    }

    public FileStat getFileStat() {
        return fileStat;
    }

    public void setFileStat(FileStat fileStat) {
        this.fileStat = fileStat;
    }
}
