package com.example.demo.godclassrefactoring.refactored;

/**
 * Data validation implementation
 */
public class ValidationProcessor implements ProcessingStrategy {
    @Override
    public Object process(Object data) {
        System.out.println("Validating data quality");
        // Validation logic would go here
        return "Validated: " + data.toString();
    }
}