package com.example.demo.godclassrefactoring.refactored;

import java.util.List;

/**
 * Factory Pattern for Data Sources
 * Centralizes creation of data loaders
 */
public interface DataSource {
    Object loadData(List<String> rawData);
    String formatOutput(Object processedData);
}
