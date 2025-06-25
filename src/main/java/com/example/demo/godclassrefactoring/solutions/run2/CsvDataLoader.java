package com.example.demo.godclassrefactoring.solutions.run2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Concrete implementation for loading CSV data.
 * Handles CSV-specific parsing logic.
 */
public class CsvDataLoader implements DataLoader {
    
    @Override
    public Object loadData(List<String> rawData) {
        System.out.println("Loading CSV data from source");
        
        // CSV parsing logic
        Map<String, Object> csvData = new HashMap<>();
        csvData.put("type", "csv");
        csvData.put("rows", rawData.size());
        csvData.put("format", "comma-separated");
        
        return csvData;
    }
    
    @Override
    public String getDataType() {
        return "csv";
    }
}
