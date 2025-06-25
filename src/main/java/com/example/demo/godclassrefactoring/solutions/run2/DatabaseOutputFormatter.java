package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Concrete implementation for database output formatting.
 * Handles database-specific output formatting logic.
 */
public class DatabaseOutputFormatter implements OutputFormatter {
    
    @Override
    public String formatOutput(Object data) {
        return "Database Output: " + data.toString();
    }
    
    @Override
    public String getFormatType() {
        return "database";
    }
}
