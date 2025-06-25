package com.example.demo.godclassrefactoring.solutions.run2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Concrete implementation for loading JSON data.
 * Handles JSON-specific parsing and API calls.
 */
public class JsonDataLoader implements DataLoader {
    
    @Override
    public Object loadData(List<String> rawData) {
        System.out.println("Loading JSON data from REST API");
        
        // JSON parsing and API calls
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("type", "json");
        jsonData.put("apiResponse", "success");
        jsonData.put("endpoints", rawData.size());
        
        return jsonData;
    }
    
    @Override
    public String getDataType() {
        return "json";
    }
}
