package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Concrete implementation for data transformation processing.
 * Handles data transformation rules and logic.
 */
public class TransformationProcessor implements DataProcessor {
    
    @Override
    public Object processData(Object data) {
        System.out.println("Applying data transformation rules");
        
        // Data transformation rules
        return "Transformed: " + data.toString();
    }
    
    @Override
    public String getProcessingType() {
        return "transformation";
    }
}
