package com.example.demo.godclassrefactoring.solutions.run1;

import java.util.List;

public class XmlDataLoader implements DataLoader {
    @Override
    public Object loadData(List<String> source) {
        System.out.println("Loading XML data from legacy system");
        // Simulate XML data loading
        return "XML Data";
    }
}

