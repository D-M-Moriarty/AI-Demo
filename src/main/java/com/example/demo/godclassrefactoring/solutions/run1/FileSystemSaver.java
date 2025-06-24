package com.example.demo.godclassrefactoring.solutions.run1;

public class FileSystemSaver implements DataSaver {
    @Override
    public void saveData(Object data) {
        System.out.println("Saving data to file system: " + data);
        // Simulate saving to file system
    }
}

