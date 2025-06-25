package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Concrete implementation for JSON output formatting.
 * Handles JSON-specific output formatting logic.
 */
public class JsonOutputFormatter implements OutputFormatter {
    
    @Override
    public String formatOutput(Object data) {
        return "JSON Output: " + data.toString();
    }
    
    @Override
    public String getFormatType() {
        return "json";
    }
}
