package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Strategy interface for data processing operations.
 * Follows the Strategy pattern to allow different processing implementations.
 */
public interface DataProcessor {
    
    /**
     * Processes the loaded data according to the specific processing strategy.
     * 
     * @param data the data to be processed
     * @return the processed data object
     */
    Object processData(Object data);
    
    /**
     * Returns the type of processing this processor handles.
     * 
     * @return the processing type identifier
     */
    String getProcessingType();
}
