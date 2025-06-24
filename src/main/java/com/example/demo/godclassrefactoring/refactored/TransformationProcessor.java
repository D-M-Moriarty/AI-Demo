package com.example.demo.godclassrefactoring.refactored;

/**
 * Data transformation implementation
 */
public class TransformationProcessor implements ProcessingStrategy {
    @Override
    public Object process(Object data) {
        System.out.println("Applying data transformation rules");
        // Transformation logic would go here
        return "Transformed: " + data.toString();
    }
}
