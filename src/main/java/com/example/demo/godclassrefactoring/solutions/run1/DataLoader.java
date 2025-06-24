package com.example.demo.godclassrefactoring.solutions.run1;

import java.util.List;

/**
 * Defines the contract for data loading operations.
 * Implementations of this interface will handle loading data from a specific source.
 */
public interface DataLoader {
    /**
     * Loads data from a given source.
     *
     * @param source The source of the data, represented as a list of strings.
     * @return The loaded data as an object.
     */
    Object loadData(List<String> source);
}

