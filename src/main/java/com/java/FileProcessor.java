package com.java;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class FileProcessor {
    public void processFile(String inputFilename, String outputFilename) throws Exception {
        FileFormatParser parser = getParser(inputFilename);
        FileFormatWriter writer = getWriter(outputFilename);

        try (FileInputStream fis = new FileInputStream(inputFilename);
             FileOutputStream fos = new FileOutputStream(outputFilename)) {
            List<CreditCardData> data = parser.parse(fis);
            writer.write(data, fos);
        }
    }

    private FileFormatParser getParser(String filename) {
        if (filename.endsWith(".csv")) {
            return new CSVParser();
        } else if (filename.endsWith(".xml")) {
            return new XMLParser();
        } else if (filename.endsWith(".json")) {
            return new JSONParser();
        }
        throw new IllegalArgumentException("Unsupported file format");
    }

    private FileFormatWriter getWriter(String filename) {
        if (filename.endsWith(".csv")) {
            return new CSVWriter();
        } else if (filename.endsWith(".xml")) {
            return new XMLWriter();
        } else if (filename.endsWith(".json")) {
            return new JSONWriter();
        }
        throw new IllegalArgumentException("Unsupported file format");
    }
}
