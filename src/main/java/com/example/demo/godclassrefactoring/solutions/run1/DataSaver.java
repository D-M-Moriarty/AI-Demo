package com.example.demo.godclassrefactoring.solutions.run1;

/**
 * Defines the contract for data saving operations.
 * Implementations of this interface will handle saving data to a specific destination.
 */
public interface DataSaver {
    /**
     * Saves the given data.
     *
     * @param data The data to be saved.
     */
    void saveData(Object data);
}

