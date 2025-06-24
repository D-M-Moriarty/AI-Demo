package com.example.demo.godclassrefactoring.refactored;

/**
 * Data aggregation implementation
 */
public class AggregationProcessor implements ProcessingStrategy {
    @Override
    public Object process(Object data) {
        System.out.println("Performing data aggregation");
        // Aggregation logic would go here
        return "Aggregated: " + data.toString();
    }
}
