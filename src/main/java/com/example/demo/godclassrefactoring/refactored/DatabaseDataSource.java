package com.example.demo.godclassrefactoring.refactored;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Database data source implementation
 */
public class DatabaseDataSource implements DataSource {
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
