package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Concrete implementation for analytics processing.
 * Handles complex analytics algorithms.
 */
public class AnalyticsProcessor implements DataProcessor {
    
    @Override
    public Object processData(Object data) {
        System.out.println("Running analytics algorithms");
        
        // Complex analytics algorithms
        return "Analytics result for: " + data.toString();
    }
    
    @Override
    public String getProcessingType() {
        return "analytics";
    }
}
