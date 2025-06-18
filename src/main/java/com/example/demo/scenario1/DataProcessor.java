package com.example.demo.scenario1;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * LEGACY CODE - A monolithic class that handles all types of data processing
 * Perfect example for demonstrating Factory + Strategy refactoring with Copilot Chat.
 * 
 * Issues to discuss with Copilot:
 * - Violates Single Responsibility Principle
 * - Hard to test and maintain
 * - Difficult to extend with new processing types
 * - Multiple switch statements (code smell)
 * 
 * Ask Copilot: "This class violates SOLID principles. How would you refactor it using design patterns?"
 * Follow up: "I'm thinking factory + strategy pattern. Walk me through that approach"
 */
public class DataProcessor {
    
    // This class does WAY too much!
    
    public String processData(String dataType, String processingType, List<String> rawData) {
        // Data loading logic - varies by source type
        Object loadedData = null;
        switch (dataType.toLowerCase()) {
            case "csv":
                loadedData = loadCsvData(rawData);
                System.out.println("Loading CSV data from source");
                break;
            case "json":
                loadedData = loadJsonData(rawData);
                System.out.println("Loading JSON data from REST API");
                break;
            case "xml":
                loadedData = loadXmlData(rawData);
                System.out.println("Loading XML data from legacy system");
                break;
            case "database":
                loadedData = loadDatabaseData(rawData);
                System.out.println("Loading data from database query");
                break;
            default:
                throw new IllegalArgumentException("Unsupported data type: " + dataType);
        }
        
        // Data processing logic - varies by processing type
        Object processedData = null;
        switch (processingType.toLowerCase()) {
            case "analytics":
                processedData = processAnalytics(loadedData);
                System.out.println("Running analytics algorithms");
                break;
            case "transformation":
                processedData = processTransformation(loadedData);
                System.out.println("Applying data transformation rules");
                break;
            case "validation":
                processedData = processValidation(loadedData);
                System.out.println("Validating data quality");
                break;
            case "aggregation":
                processedData = processAggregation(loadedData);
                System.out.println("Performing data aggregation");
                break;
            default:
                throw new IllegalArgumentException("Unsupported processing type: " + processingType);
        }
        
        // Output formatting logic - also varies by type
        String formattedOutput = null;
        switch (dataType.toLowerCase()) {
            case "csv":
                formattedOutput = formatCsvOutput(processedData);
                break;
            case "json":
                formattedOutput = formatJsonOutput(processedData);
                break;
            case "xml":
                formattedOutput = formatXmlOutput(processedData);
                break;
            case "database":
                formattedOutput = formatDatabaseOutput(processedData);
                break;
        }
        
        // Logging and monitoring
        logProcessingMetrics(dataType, processingType, rawData.size());
        
        return formattedOutput;
    }
    
    // Data loading methods - each has different logic
    private Object loadCsvData(List<String> rawData) {
        // CSV parsing logic
        Map<String, Object> csvData = new HashMap<>();
        csvData.put("type", "csv");
        csvData.put("rows", rawData.size());
        return csvData;
    }
    
    private Object loadJsonData(List<String> rawData) {
        // JSON parsing and API calls
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("type", "json");
        jsonData.put("apiResponse", "success");
        return jsonData;
    }
    
    private Object loadXmlData(List<String> rawData) {
        // XML parsing with namespace handling
        Map<String, Object> xmlData = new HashMap<>();
        xmlData.put("type", "xml");
        xmlData.put("schema", "legacy");
        return xmlData;
    }
    
    private Object loadDatabaseData(List<String> rawData) {
        // Database connection and query execution
        Map<String, Object> dbData = new HashMap<>();
        dbData.put("type", "database");
        dbData.put("connection", "active");
        return dbData;
    }
    
    // Processing methods - each has different algorithms
    private Object processAnalytics(Object data) {
        // Complex analytics algorithms
        return "Analytics result for: " + data.toString();
    }
    
    private Object processTransformation(Object data) {
        // Data transformation rules
        return "Transformed: " + data.toString();
    }
    
    private Object processValidation(Object data) {
        // Data quality validation
        return "Validated: " + data.toString();
    }
    
    private Object processAggregation(Object data) {
        // Data aggregation logic
        return "Aggregated: " + data.toString();
    }
    
    // Output formatting methods
    private String formatCsvOutput(Object data) {
        return "CSV Output: " + data.toString();
    }
    
    private String formatJsonOutput(Object data) {
        return "JSON Output: " + data.toString();
    }
    
    private String formatXmlOutput(Object data) {
        return "XML Output: " + data.toString();
    }
    
    private String formatDatabaseOutput(Object data) {
        return "Database Output: " + data.toString();
    }
    
    private void logProcessingMetrics(String dataType, String processingType, int dataSize) {
        System.out.println("Processed " + dataSize + " records of " + dataType + " using " + processingType);
    }
}
