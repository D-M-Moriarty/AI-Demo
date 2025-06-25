package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Concrete implementation for data validation processing.
 * Handles data quality validation logic.
 */
public class ValidationProcessor implements DataProcessor {
    
    @Override
    public Object processData(Object data) {
        System.out.println("Validating data quality");
        
        // Data quality validation
        return "Validated: " + data.toString();
    }
    
    @Override
    public String getProcessingType() {
        return "validation";
    }
}
