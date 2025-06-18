package com.example.demo.scenario1.refactored;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory for creating processing strategies
 */
public class Factories {
    private static final Map<String, ProcessingStrategy> strategies = new HashMap<>();
    
    static {
        strategies.put("analytics", new AnalyticsProcessor());
        strategies.put("transformation", new TransformationProcessor());
        strategies.put("validation", new ValidationProcessor());
        strategies.put("aggregation", new AggregationProcessor());
    }
    
    public static ProcessingStrategy getStrategy(String type) {
        ProcessingStrategy strategy = strategies.get(type.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported processing type: " + type);
        }
        return strategy;
    }
}
