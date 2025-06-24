package com.example.demo.godclassrefactoring.solutions.run1;

import java.util.List;

public class OrderProcessor {

    private final DataLoader dataLoader;
    private final DataProcessor dataProcessor;
    private final DataSaver dataSaver;

    public OrderProcessor(String dataType, String processingType, String saveType) {
        this.dataLoader = DataHandlerFactory.createDataLoader(dataType);
        this.dataProcessor = DataHandlerFactory.createDataProcessor(processingType);
        this.dataSaver = DataHandlerFactory.createDataSaver(saveType);
    }

    public void processData(List<String> rawData) {
        Object loadedData = dataLoader.loadData(rawData);
        Object processedData = dataProcessor.process(loadedData);
        dataSaver.saveData(processedData);
    }

    public static void main(String[] args) {
        // Example 1: Process and validate CSV data, then save to a file system
        OrderProcessor processor1 = new OrderProcessor("csv", "validate", "filesystem");
        processor1.processData(List.of("raw", "csv", "data"));

        System.out.println("---------------------");

        // Example 2: Process and transform JSON data, then save to a database
        OrderProcessor processor2 = new OrderProcessor("json", "transform", "database");
        processor2.processData(List.of("raw", "json", "data"));
    }
}

