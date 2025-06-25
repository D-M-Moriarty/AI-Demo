package com.example.demo.godclassrefactoring.solutions.run2;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class for creating data processor instances.
 * Implements the Factory pattern to manage DataProcessor creation.
 */
public class DataProcessorFactory {
    
    private static final Map<String, DataProcessor> processors = new HashMap<>();
    
    static {
        // Register available data processors
        registerProcessor(new AnalyticsProcessor());
        registerProcessor(new TransformationProcessor());
        registerProcessor(new ValidationProcessor());
        registerProcessor(new AggregationProcessor());
    }
    
    /**
     * Registers a new data processor.
     * 
     * @param processor the data processor to register
     */
    public static void registerProcessor(DataProcessor processor) {
        processors.put(processor.getProcessingType().toLowerCase(), processor);
    }
    
    /**
     * Creates a data processor for the specified processing type.
     * 
     * @param processingType the type of processing to perform
     * @return the appropriate data processor
     * @throws IllegalArgumentException if the processing type is not supported
     */
    public static DataProcessor createProcessor(String processingType) {
        DataProcessor processor = processors.get(processingType.toLowerCase());
        if (processor == null) {
            throw new IllegalArgumentException("Unsupported processing type: " + processingType);
        }
        return processor;
    }
    
    /**
     * Returns all available processing types.
     * 
     * @return array of supported processing types
     */
    public static String[] getAvailableProcessingTypes() {
        return processors.keySet().toArray(new String[0]);
    }
}
