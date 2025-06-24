package com.example.demo.godclassrefactoring.solutions.run1;

import java.util.List;

public class JsonDataLoader implements DataLoader {
    @Override
    public Object loadData(List<String> source) {
        System.out.println("Loading JSON data from REST API");
        // Simulate JSON data loading
        return "JSON Data";
    }
}

