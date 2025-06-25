package com.example.demo.godclassrefactoring.solutions.run2;

/**
 * Service class responsible for logging and monitoring processing metrics.
 * Follows Single Responsibility Principle by handling only metrics-related operations.
 */
public class ProcessingMetricsService {
    
    /**
     * Logs processing metrics for monitoring and analytics purposes.
     * 
     * @param dataType the type of data that was processed
     * @param processingType the type of processing that was performed
     * @param dataSize the size of the data that was processed
     */
    public void logProcessingMetrics(String dataType, String processingType, int dataSize) {
        System.out.println("Processed " + dataSize + " records of " + dataType + " using " + processingType);
        
        // Additional metrics logging could be added here:
        // - Performance timing
        // - Memory usage
        // - Error rates
        // - Success rates
    }
    
    /**
     * Logs performance metrics for a processing operation.
     * 
     * @param dataType the type of data processed
     * @param processingType the type of processing performed
     * @param processingTimeMs the processing time in milliseconds
     */
    public void logPerformanceMetrics(String dataType, String processingType, long processingTimeMs) {
        System.out.println("Processing completed in " + processingTimeMs + "ms for " 
                         + dataType + " with " + processingType + " processing");
    }
}
