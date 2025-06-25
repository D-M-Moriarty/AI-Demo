package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Strategy interface for output formatting operations.
 * Follows the Strategy pattern to allow different formatting implementations.
 */
public interface OutputFormatter {
    
    /**
     * Formats the processed data into the desired output format.
     * 
     * @param data the processed data to be formatted
     * @return the formatted output string
     */
    String formatOutput(Object data);
    
    /**
     * Returns the format type this formatter handles.
     * 
     * @return the format type identifier
     */
    String getFormatType();
}
