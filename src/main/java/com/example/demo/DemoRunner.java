package com.example.demo;

import com.example.demo.godclassrefactoring.OrderProcessor;
import com.example.demo.godclassrefactoring.refactored.RefactoredDataProcessor;

import java.util.Arrays;
import java.util.List;

/**
 * Demo runner to showcase god class refactoring.
 * Run this to see the before/after comparison of the refactored code.
 */
public class DemoRunner {
    
    public static void main(String[] args) {
        System.out.println("=== GitHub Copilot God Class Refactoring Demo ===\n");
        
        // Test data for demonstration
        List<String> testData = Arrays.asList("row1", "row2", "row3");
        
        // Demonstrate the god class (before refactoring)
        demonstrateGodClass(testData);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Demonstrate the refactored version (after refactoring)
        demonstrateRefactoredVersion(testData);
    }
    
    private static void demonstrateGodClass(List<String> testData) {
        System.out.println("🔴 BEFORE: God Class (OrderProcessor)");
        System.out.println("File: godclassrefactoring/OrderProcessor.java");
        System.out.println("Issues: Multiple responsibilities, switch statements, hard to test\n");
        
        OrderProcessor godClass = new OrderProcessor();
        String result = godClass.processData("csv", "analytics", testData);
        
        System.out.println("Result: " + result);
    }
    
    private static void demonstrateRefactoredVersion(List<String> testData) {
        System.out.println("🟢 AFTER: Refactored (Factory + Strategy Pattern)");
        System.out.println("File: godclassrefactoring/refactored/RefactoredDataProcessor.java");
        System.out.println("Benefits: Single responsibility, extensible, testable\n");
        
        RefactoredDataProcessor refactoredProcessor = new RefactoredDataProcessor();
        String result = refactoredProcessor.processData("csv", "analytics", testData);
        
        System.out.println("Result: " + result);
        System.out.println("\n✅ Same functionality, better design!");
    }
}