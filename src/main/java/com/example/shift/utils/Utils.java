package com.example.shift.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Utils {

    public static boolean deleteFileIfExists(String filename) {
        File file = new File(filename);
        if (file.isFile()) return file.delete();
        return true;
    }

    public static boolean isNumeric(String line) {
        String regex = "^-?[0-9]\\d*$";
        return Pattern.matches(regex, line);
    }

    public static boolean isFloat(String line) {
        String regex = "^[-+]?[0-9]*[.]?[0-9]+(?:[eE][-+]?[0-9]+)?$";
        return Pattern.matches(regex, line);
    }

    public static String getAbsolutePath(String fileName) throws CustomException {
        Path path = Paths.get(fileName);
        if (!path.isAbsolute()) {
            path = Paths.get(System.getProperty("user.dir") + path);
        }
        if (!Files.exists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e) {
                throw new CustomException("Unable to create path for outputfile " + path.getParent());
            }
        }
        return path.toString();
    }

}
