package com.example.demo.godclassrefactoring.refactored;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * JSON data source implementation
 */
public class JsonDataSource implements DataSource {
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
