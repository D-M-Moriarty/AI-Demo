package com.example.demo.godclassrefactoring.solutions.run1;

import java.util.List;

public class CsvDataLoader implements DataLoader {
    @Override
    public Object loadData(List<String> source) {
        System.out.println("Loading CSV data from source");
        // Simulate CSV data loading
        return "CSV Data";
    }
}

