package com.example.demo.godclassrefactoring.solutions.run2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Concrete implementation for loading database data.
 * Handles database connection and query execution.
 */
public class DatabaseDataLoader implements DataLoader {
    
    @Override
    public Object loadData(List<String> rawData) {
        System.out.println("Loading data from database query");
        
        // Database connection and query execution
        Map<String, Object> dbData = new HashMap<>();
        dbData.put("type", "database");
        dbData.put("connection", "active");
        dbData.put("queries", rawData.size());
        
        return dbData;
    }
    
    @Override
    public String getDataType() {
        return "database";
    }
}
