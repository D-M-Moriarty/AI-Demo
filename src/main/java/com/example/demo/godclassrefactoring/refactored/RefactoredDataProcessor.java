package com.example.demo.godclassrefactoring.refactored;

import java.util.List;

/**
 * REFACTORED SOLUTION - Clean, maintainable data processor
 * Uses Factory + Strategy patterns to solve the problems in the original God class
 * 
 * Benefits:
 * - Single Responsibility: Each class has one job
 * - Open/Closed: Easy to add new processors without modifying existing code
 * - Testable: Can unit test each component in isolation
 * - Maintainable: Changes to one processing type don't affect others
 */
public class RefactoredDataProcessor {
    
    /**
     * Main processing method - now clean and focused
     * The workflow is self-documenting: load → process → format
     */
    public String processData(String dataType, String processingType, List<String> rawData) {
        // Use factory to get the appropriate data source
        DataSource dataSource = DataSourceFactory.getDataSource(dataType);
        
        // Use factory to get the appropriate processing strategy
        ProcessingStrategy processor = ProcessingStrategyFactory.getStrategy(processingType);
        
        // Clean workflow: load → process → format
        Object loadedData = dataSource.loadData(rawData);
        Object processedData = processor.process(loadedData);
        String result = dataSource.formatOutput(processedData);
        
        // Single responsibility for logging
        logProcessingMetrics(dataType, processingType, rawData.size());
        
        return result;
    }
    
    private void logProcessingMetrics(String dataType, String processingType, int dataSize) {
        System.out.println("Processed " + dataSize + " records of " + dataType + " using " + processingType);
    }
}
