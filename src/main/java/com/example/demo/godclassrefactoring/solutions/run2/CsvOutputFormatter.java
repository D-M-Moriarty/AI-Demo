package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Concrete implementation for CSV output formatting.
 * Handles CSV-specific output formatting logic.
 */
public class CsvOutputFormatter implements OutputFormatter {
    
    @Override
    public String formatOutput(Object data) {
        return "CSV Output: " + data.toString();
    }
    
    @Override
    public String getFormatType() {
        return "csv";
    }
}
