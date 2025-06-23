package com.example.demo.godclassrefactoring.refactored;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Factory Pattern for Data Sources
 * Centralizes creation of data loaders
 */
public interface DataSource {
    Object loadData(List<String> rawData);
    String formatOutput(Object processedData);
}

/**
 * CSV data source implementation
 */
class CsvDataSource implements DataSource {
    @Override
    public Object loadData(List<String> rawData) {
        System.out.println("Loading CSV data from source");
        Map<String, Object> csvData = new HashMap<>();
        csvData.put("type", "csv");
        csvData.put("rows", rawData.size());
        return csvData;
    }
    
    @Override
    public String formatOutput(Object processedData) {
        return "CSV Output: " + processedData.toString();
    }
}

/**
 * JSON data source implementation
 */
class JsonDataSource implements DataSource {
    @Override
    public Object loadData(List<String> rawData) {
        System.out.println("Loading JSON data from REST API");
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("type", "json");
        jsonData.put("apiResponse", "success");
        return jsonData;
    }
    
    @Override
    public String formatOutput(Object processedData) {
        return "JSON Output: " + processedData.toString();
    }
}

/**
 * XML data source implementation
 */
class XmlDataSource implements DataSource {
    @Override
    public Object loadData(List<String> rawData) {
        System.out.println("Loading XML data from legacy system");
        Map<String, Object> xmlData = new HashMap<>();
        xmlData.put("type", "xml");
        xmlData.put("schema", "legacy");
        return xmlData;
    }
    
    @Override
    public String formatOutput(Object processedData) {
        return "XML Output: " + processedData.toString();
    }
}

/**
 * Database data source implementation
 */
class DatabaseDataSource implements DataSource {
    @Override
    public Object loadData(List<String> rawData) {
        System.out.println("Loading data from database query");
        Map<String, Object> dbData = new HashMap<>();
        dbData.put("type", "database");
        dbData.put("connection", "active");
        return dbData;
    }
    
    @Override
    public String formatOutput(Object processedData) {
        return "Database Output: " + processedData.toString();
    }
}
