package com.example.demo.godclassrefactoring.solutions.run2;

import com.example.demo.godclassrefactoring.OrderProcessor;
import java.util.Arrays;
import java.util.List;

/**
 * Comparison demonstration showing the benefits of the refactored solution
 * versus the legacy OrderProcessor implementation.
 */
public class LegacyVsRefactoredComparison {
    
    public static void main(String[] args) {
        // Sample data for testing
        List<String> sampleData = Arrays.asList(
            "Sample data row 1",
            "Sample data row 2", 
            "Sample data row 3"
        );
        
        System.out.println("=== Legacy vs Refactored OrderProcessor Comparison ===\n");
        
        // Test with legacy processor
        System.out.println("--- LEGACY IMPLEMENTATION ---");
        OrderProcessor legacyProcessor = new OrderProcessor();
        
        long legacyStart = System.currentTimeMillis();
        String legacyResult = legacyProcessor.processData("csv", "analytics", sampleData);
        long legacyTime = System.currentTimeMillis() - legacyStart;
        
        System.out.println("Legacy Result: " + legacyResult);
        System.out.println("Legacy Processing Time: " + legacyTime + "ms");
        System.out.println();
        
        // Test with refactored processor
        System.out.println("--- REFACTORED IMPLEMENTATION ---");
        RefactoredOrderProcessor refactoredProcessor = new RefactoredOrderProcessor();
        
        long refactoredStart = System.currentTimeMillis();
        String refactoredResult = refactoredProcessor.processData("csv", "analytics", sampleData);
        long refactoredTime = System.currentTimeMillis() - refactoredStart;
        
        System.out.println("Refactored Result: " + refactoredResult);
        System.out.println("Refactored Processing Time: " + refactoredTime + "ms");
        System.out.println();
        
        // Show extensibility benefits
        System.out.println("--- EXTENSIBILITY DEMONSTRATION ---");
        System.out.println("Available Data Types: " + Arrays.toString(refactoredProcessor.getAvailableDataTypes()));
        System.out.println("Available Processing Types: " + Arrays.toString(refactoredProcessor.getAvailableProcessingTypes()));
        System.out.println("Available Output Formats: " + Arrays.toString(refactoredProcessor.getAvailableOutputFormats()));
        System.out.println();
        
        // Demonstrate easy addition of new functionality
        System.out.println("--- ADDING NEW FUNCTIONALITY ---");
        System.out.println("To add a new data type to the legacy system: Modify OrderProcessor class");
        System.out.println("To add a new data type to the refactored system: Create new DataLoader implementation and register");
        System.out.println();
        
        // Show testability benefits
        System.out.println("--- TESTABILITY COMPARISON ---");
        System.out.println("Legacy: Single large class, difficult to unit test individual components");
        System.out.println("Refactored: Each component can be tested independently with mock dependencies");
        System.out.println();
        
        System.out.println("=== Comparison Complete ===");
        
        // Summary of benefits
        System.out.println("\n--- REFACTORING BENEFITS SUMMARY ---");
        System.out.println("✓ Single Responsibility: Each class has one clear purpose");
        System.out.println("✓ Open/Closed: New functionality added without modifying existing code");
        System.out.println("✓ Dependency Inversion: Depends on abstractions, not concrete classes");
        System.out.println("✓ Strategy Pattern: Runtime selection of algorithms");
        System.out.println("✓ Factory Pattern: Centralized object creation");
        System.out.println("✓ Improved Testability: Independent component testing");
        System.out.println("✓ Better Maintainability: Localized changes");
        System.out.println("✓ Enhanced Extensibility: Easy to add new types");
        System.out.println("✓ Performance Monitoring: Built-in metrics collection");
        System.out.println("✓ Error Handling: Proper exception management");
    }
}
