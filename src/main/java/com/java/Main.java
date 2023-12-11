package com.java;

public class Main {
    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();
        String basePath = System.getProperty("user.dir"); // This will get the root path of the project
        String csvInputPath = basePath + "/src/main/resources/input_file.csv"; // Adjust the path as necessary
        String csvOutputPath = basePath + "/src/main/resources/output_file.csv"; // Adjust the path as necessary
        String xmlInputPath = basePath + "/src/main/resources/input_file.xml"; // Adjust the path as necessary
        String xmlOutputPath = basePath + "/src/main/resources/output_file.xml"; // Adjust the path as necessary
        String jsonInputPath = basePath + "/src/main/resources/input_file.json"; // Adjust the path as necessary
        String jsonOutputPath = basePath + "/src/main/resources/output_file.json"; // Adjust the path as necessary

        try {
            processor.processFile(csvInputPath, csvOutputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            processor.processFile(jsonInputPath, jsonOutputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            processor.processFile(xmlInputPath, xmlOutputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
