package com.example.demo.godclassrefactoring.solutions.run2;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstration class showing how to use the refactored OrderProcessor.
 * This class shows the benefits of the refactored design:
 * - Clean, readable code
 * - Easy to extend with new types
 * - Proper separation of concerns
 * - Testable components
 */
public class RefactoredOrderProcessorDemo {
    
    public static void main(String[] args) {
        // Create the refactored processor
        RefactoredOrderProcessor processor = new RefactoredOrderProcessor();
        
        // Sample data for testing
        List<String> sampleData = Arrays.asList(
            "Sample data row 1",
            "Sample data row 2", 
            "Sample data row 3",
            "Sample data row 4",
            "Sample data row 5"
        );
        
        System.out.println("=== Refactored OrderProcessor Demonstration ===\n");
        
        // Show available options
        System.out.println("Available Data Types: " + Arrays.toString(processor.getAvailableDataTypes()));
        System.out.println("Available Processing Types: " + Arrays.toString(processor.getAvailableProcessingTypes()));
        System.out.println("Available Output Formats: " + Arrays.toString(processor.getAvailableOutputFormats()));
        System.out.println();
        
        // Test different combinations
        String[][] testCombinations = {
            {"csv", "analytics"},
            {"json", "transformation"},
            {"xml", "validation"},
            {"database", "aggregation"}
        };
        
        for (String[] combination : testCombinations) {
            String dataType = combination[0];
            String processingType = combination[1];
            
            System.out.println("--- Processing " + dataType.toUpperCase() + " with " + processingType.toUpperCase() + " ---");
            
            try {
                String result = processor.processData(dataType, processingType, sampleData);
                System.out.println("Result: " + result);
                
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
            
            System.out.println();
        }
        
        // Demonstrate error handling for unsupported types
        System.out.println("--- Testing Error Handling ---");
        try {
            processor.processData("unsupported", "analytics", sampleData);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
        
        try {
            processor.processData("csv", "unsupported", sampleData);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
        
        System.out.println("\n=== Demo Complete ===");
    }
}
