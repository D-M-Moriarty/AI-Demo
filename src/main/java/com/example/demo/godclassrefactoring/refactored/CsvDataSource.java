package com.example.demo.godclassrefactoring.refactored;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * CSV data source implementation
 */
public class CsvDataSource implements DataSource {
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
