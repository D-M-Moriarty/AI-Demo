package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Concrete implementation for XML output formatting.
 * Handles XML-specific output formatting logic.
 */
public class XmlOutputFormatter implements OutputFormatter {
    
    @Override
    public String formatOutput(Object data) {
        return "XML Output: " + data.toString();
    }
    
    @Override
    public String getFormatType() {
        return "xml";
    }
}
