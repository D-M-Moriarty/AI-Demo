package com.example.demo.godclassrefactoring.solutions.run1;

public class ValidateProcessor implements DataProcessor {
    @Override
    public Object process(Object data) {
        System.out.println("Validating data: " + data);
        // Simulate data validation
        return data;
    }
}

