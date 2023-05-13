package com.yashasvi;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class Utils {
    public static void validatePaths(String input_path, String output_path) {
        validateInputPathIfExists(input_path);
        validateTheFileExtension(input_path, output_path);
    }

    public static void validateInputPathIfExists(String input_path) {
        File file = new File(input_path);
        if (!file.isFile()) {
            throw new RuntimeException("Input path does not exist");
        }
    }

    public static void validateTheFileExtension(String input_path, String output_path) {
        String input_extension = FilenameUtils.getExtension(input_path);
        String output_extension = FilenameUtils.getExtension(output_path);
        if (!input_extension.equals(output_extension)) {
            throw new RuntimeException("Input and output extensions should be the same");
        }
    }
}