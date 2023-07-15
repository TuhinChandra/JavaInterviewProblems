package com.tuhin.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtils {
    public static String getFileContent(final ClassLoader classLoader, final String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(filePath)));
        StringBuilder content = new StringBuilder();
        String str;
        while ((str = reader.readLine()) != null) {
            content.append(str);
        }
        return content.toString();
    }
}
