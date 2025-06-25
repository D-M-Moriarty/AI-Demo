package com.example.demo.godclassrefactoring.solutions.run2;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class for creating data loader instances.
 * Implements the Factory pattern to manage DataLoader creation.
 */
public class DataLoaderFactory {
    
    private static final Map<String, DataLoader> loaders = new HashMap<>();
    
    static {
        // Register available data loaders
        registerLoader(new CsvDataLoader());
        registerLoader(new JsonDataLoader());
        registerLoader(new XmlDataLoader());
        registerLoader(new DatabaseDataLoader());
    }
    
    /**
     * Registers a new data loader.
     * 
     * @param loader the data loader to register
     */
    public static void registerLoader(DataLoader loader) {
        loaders.put(loader.getDataType().toLowerCase(), loader);
    }
    
    /**
     * Creates a data loader for the specified data type.
     * 
     * @param dataType the type of data to load
     * @return the appropriate data loader
     * @throws IllegalArgumentException if the data type is not supported
     */
    public static DataLoader createLoader(String dataType) {
        DataLoader loader = loaders.get(dataType.toLowerCase());
        if (loader == null) {
            throw new IllegalArgumentException("Unsupported data type: " + dataType);
        }
        return loader;
    }
    
    /**
     * Returns all available data types.
     * 
     * @return array of supported data types
     */
    public static String[] getAvailableDataTypes() {
        return loaders.keySet().toArray(new String[0]);
    }
}
