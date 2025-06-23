package com.example.demo.godclassrefactoring.refactored;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory for creating data sources
 */
public class DataSourceFactory {
    private static final Map<String, DataSource> dataSources = new HashMap<>();
    
    static {
        dataSources.put("csv", new CsvDataSource());
        dataSources.put("json", new JsonDataSource());
        dataSources.put("xml", new XmlDataSource());
        dataSources.put("database", new DatabaseDataSource());
    }
    
    public static DataSource getDataSource(String type) {
        DataSource source = dataSources.get(type.toLowerCase());
        if (source == null) {
            throw new IllegalArgumentException("Unsupported data type: " + type);
        }
        return source;
    }
}
