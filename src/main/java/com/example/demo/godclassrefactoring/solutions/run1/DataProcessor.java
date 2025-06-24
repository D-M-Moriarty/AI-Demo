package com.example.demo.godclassrefactoring.solutions.run1;

/**
 * Defines the contract for data processing operations.
 * Implementations of this interface will handle a specific type of data processing.
 */
public interface DataProcessor {
    /**
     * Processes the given data.
     *
     * @param data The data to be processed.
     * @return The processed data.
     */
    Object process(Object data);
}

