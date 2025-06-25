package com.example.demo.godclassrefactoring.solutions.run2;

import java.util.List;

/**
 * Strategy interface for data loading operations.
 * Follows the Strategy pattern to allow different data loading implementations.
 */
public interface DataLoader {
    
    /**
     * Loads data from the specified raw data source.
     * 
     * @param rawData the raw data to be loaded
     * @return the loaded data object
     */
    Object loadData(List<String> rawData);
    
    /**
     * Returns the type of data this loader handles.
     * 
     * @return the data type identifier
     */
    String getDataType();
}
