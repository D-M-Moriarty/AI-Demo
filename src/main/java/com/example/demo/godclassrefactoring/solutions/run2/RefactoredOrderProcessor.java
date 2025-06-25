package com.example.demo.godclassrefactoring.solutions.run2;

import java.util.List;

/**
 * Refactored OrderProcessor that follows SOLID principles.
 * Uses Strategy pattern and dependency injection for flexible and extensible design.
 * 
 * Key improvements:
 * - Single Responsibility: Only orchestrates the processing pipeline
 * - Open/Closed: New data types, processors, and formatters can be added without modification
 * - Dependency Inversion: Depends on abstractions (interfaces) rather than concrete classes
 * - Strategy Pattern: Allows runtime selection of different processing strategies
 * - Factory Pattern: Centralizes object creation and management
 */
public class RefactoredOrderProcessor {
    
    private final ProcessingMetricsService metricsService;
    
    /**
     * Constructor with dependency injection.
     * 
     * @param metricsService the metrics service for logging and monitoring
     */
    public RefactoredOrderProcessor(ProcessingMetricsService metricsService) {
        this.metricsService = metricsService;
    }
    
    /**
     * Default constructor that creates default dependencies.
     */
    public RefactoredOrderProcessor() {
        this(new ProcessingMetricsService());
    }
    
    /**
     * Processes data using the specified strategies.
     * This method orchestrates the entire processing pipeline.
     * 
     * @param dataType the type of data to process
     * @param processingType the type of processing to apply
     * @param rawData the raw data to process
     * @return the formatted output string
     */
    public String processData(String dataType, String processingType, List<String> rawData) {
        long startTime = System.currentTimeMillis();
        
        try {
            // Step 1: Load data using appropriate strategy
            DataLoader loader = DataLoaderFactory.createLoader(dataType);
            Object loadedData = loader.loadData(rawData);
            
            // Step 2: Process data using appropriate strategy
            DataProcessor processor = DataProcessorFactory.createProcessor(processingType);
            Object processedData = processor.processData(loadedData);
            
            // Step 3: Format output using appropriate strategy
            OutputFormatter formatter = OutputFormatterFactory.createFormatter(dataType);
            String formattedOutput = formatter.formatOutput(processedData);
            
            // Step 4: Log metrics
            long processingTime = System.currentTimeMillis() - startTime;
            metricsService.logProcessingMetrics(dataType, processingType, rawData.size());
            metricsService.logPerformanceMetrics(dataType, processingType, processingTime);
            
            return formattedOutput;
            
        } catch (Exception e) {
            // Log error metrics
            long processingTime = System.currentTimeMillis() - startTime;
            System.err.println("Processing failed after " + processingTime + "ms: " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Returns information about available data types.
     * 
     * @return array of supported data types
     */
    public String[] getAvailableDataTypes() {
        return DataLoaderFactory.getAvailableDataTypes();
    }
    
    /**
     * Returns information about available processing types.
     * 
     * @return array of supported processing types
     */
    public String[] getAvailableProcessingTypes() {
        return DataProcessorFactory.getAvailableProcessingTypes();
    }
    
    /**
     * Returns information about available output formats.
     * 
     * @return array of supported output formats
     */
    public String[] getAvailableOutputFormats() {
        return OutputFormatterFactory.getAvailableFormatTypes();
    }
}
