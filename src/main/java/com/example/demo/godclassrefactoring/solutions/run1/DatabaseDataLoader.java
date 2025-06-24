package com.example.demo.godclassrefactoring.solutions.run1;

import java.util.List;

public class DatabaseDataLoader implements DataLoader {
    @Override
    public Object loadData(List<String> source) {
        System.out.println("Loading data from database query");
        // Simulate database data loading
        return "Database Data";
    }
}

