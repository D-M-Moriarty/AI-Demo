package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Concrete implementation for data aggregation processing.
 * Handles data aggregation algorithms and logic.
 */
public class AggregationProcessor implements DataProcessor {
    
    @Override
    public Object processData(Object data) {
        System.out.println("Performing data aggregation");
        
        // Data aggregation logic
        return "Aggregated: " + data.toString();
    }
    
    @Override
    public String getProcessingType() {
        return "aggregation";
    }
}
