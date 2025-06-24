package com.example.demo.godclassrefactoring.solutions.run1;

public class DatabaseSaver implements DataSaver {
    @Override
    public void saveData(Object data) {
        System.out.println("Saving data to database: " + data);
        // Simulate saving to database
    }
}

