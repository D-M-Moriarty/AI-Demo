package com.example.demo;

import com.example.demo.godclassrefactoring.OrderProcessor;
import com.example.demo.godclassrefactoring.refactored.RefactoredDataProcessor;
import com.example.demo.debugbuggycode.BuggyCache;

import java.util.Arrays;

/**
 * Demo runner to showcase all three scenarios.
 * Use this to quickly navigate between demo sections during presentation.
 */
public class DemoRunner {
    
    public static void main(String[] args) {
        System.out.println("=== GitHub Copilot Chat Demo ===\n");
        
        System.out.println("Scenario 1: Factory + Strategy Refactoring (3 min)");
        System.out.println("File: godclassrefactoring/OrderProcessor.java (God class)");
        System.out.println("Ask Copilot: 'This class violates SOLID principles. How would you refactor it using design patterns?'");
        System.out.println("Follow up: 'I'm thinking factory + strategy pattern. Walk me through that approach'\n");
        
        System.out.println("Scenario 2: Technical Documentation (2.5 min)");
        System.out.println("File: readmegeneration/DataProcessor.java");
        System.out.println("Ask Copilot: 'Generate comprehensive documentation for this class'");
        System.out.println("Follow up: 'Make it more focused for junior developers'\n");
        
        System.out.println("Scenario 3: Quick Problem Solving (2.5 min)");
        System.out.println("File: scenario3/BuggyCache.java");
        System.out.println("Ask Copilot: 'Help me find the bugs in this cache implementation'\n");
        
        // Quick demo of each scenario
        demonstrateScenario1();
        demonstrateScenario2();
        demonstrateScenario3();
    }
    
    private static void demonstrateScenario1() {
        System.out.println("\n--- Scenario 1: Before/After Comparison ---");
        
        // Same input data for fair comparison
        java.util.List<String> testData = Arrays.asList("row1,value1", "row2,value2", "row3,value3");
        
        System.out.println("🔴 LEGACY (God Class) - OrderProcessor:");
        OrderProcessor legacyProcessor = new OrderProcessor();
        String legacyResult = legacyProcessor.processData("csv", "analytics", testData);
        System.out.println("   Input: " + testData);
        System.out.println("   Output: " + legacyResult);
        
        System.out.println("\n🟢 REFACTORED (Factory + Strategy) - RefactoredDataProcessor:");
        RefactoredDataProcessor refactoredProcessor = new RefactoredDataProcessor();
        String refactoredResult = refactoredProcessor.processData("csv", "analytics", testData);
        System.out.println("   Input: " + testData);
        System.out.println("   Output: " + refactoredResult);
        
        System.out.println("\n✅ Results match: " + legacyResult.equals(refactoredResult));
        System.out.println("💡 Same functionality, cleaner architecture!");
    }
    
    private static void demonstrateScenario2() {
        System.out.println("\n--- Running Scenario 2 Example ---");
        System.out.println("Scenario 2 demonstrates technical documentation generation");
        System.out.println("Open readmegeneration/DataProcessor.java to see complex algorithms needing docs");
    }
    
    private static void demonstrateScenario3() {
        System.out.println("\n--- Running Scenario 3 Example ---");
        BuggyCache<String, String> cache = new BuggyCache<>(5, 1000);
        
        cache.put("demo", "value");
        System.out.println("Cache value: " + cache.get("demo"));
        System.out.println("Cache size: " + cache.size());
    }
}
