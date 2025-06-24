package com.example.demo.godclassrefactoring.solutions.run1;

public class TransformProcessor implements DataProcessor {
    @Override
    public Object process(Object data) {
        System.out.println("Transforming data: " + data);
        // Simulate data transformation
        return "Transformed " + data;
    }
}

