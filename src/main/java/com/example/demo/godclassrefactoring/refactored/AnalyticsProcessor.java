package com.example.demo.godclassrefactoring.refactored;

/**
 * Analytics processing implementation
 */
public class AnalyticsProcessor implements ProcessingStrategy {
    @Override
    public Object process(Object data) {
        System.out.println("Running analytics algorithms");
        // Complex analytics logic would go here
        return "Analytics result for: " + data.toString();
    }
}