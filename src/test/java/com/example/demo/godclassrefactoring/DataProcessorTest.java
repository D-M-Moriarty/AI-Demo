package com.example.demo.godclassrefactoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * Test class for the legacy OrderProcessor (God class).
 * These tests highlight how difficult it is to test a monolithic class.
 * Perfect for asking Copilot: "How can I make this more testable?"
 * 
 * After refactoring, you could easily test each component separately!
 */
class OrderProcessorTest {

    @Test
    @DisplayName("Should process CSV data with analytics")
    void testProcessCsvAnalytics() {
        DataProcessor processor = new DataProcessor();
        List<String> data = Arrays.asList("row1", "row2", "row3");
        
        // This test is hard to write because we can't easily mock dependencies
        // or test individual concerns in isolation
        String result = assertDoesNotThrow(() -> {
            return processor.processData("csv", "analytics", data);
        });
        
        assertNotNull(result);
        assertTrue(result.contains("CSV Output"));
    }
    
    @Test
    @DisplayName("Should process JSON data with transformation")
    void testProcessJsonTransformation() {
        DataProcessor processor = new DataProcessor();
        List<String> data = Arrays.asList("{\"test\": \"data\"}");
        
        String result = processor.processData("json", "transformation", data);
        
        assertNotNull(result);
        assertTrue(result.contains("JSON Output"));
    }
    
    @Test
    @DisplayName("Should throw exception for unsupported data type")
    void testUnsupportedDataType() {
        DataProcessor processor = new DataProcessor();
        List<String> data = Arrays.asList("test");
        
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> processor.processData("unsupported", "analytics", data)
        );
        
        assertEquals("Unsupported data type: unsupported", exception.getMessage());
    }
    
    @Test
    @DisplayName("Should throw exception for unsupported processing type")
    void testUnsupportedProcessingType() {
        DataProcessor processor = new DataProcessor();
        List<String> data = Arrays.asList("test");
        
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> processor.processData("csv", "unsupported", data)
        );
        
        assertEquals("Unsupported processing type: unsupported", exception.getMessage());
    }
    
    // TODO: Ask Copilot Chat:
    // "This monolithic class is hard to test. How would you refactor it using design patterns?"
    // "Show me how to use factory and strategy patterns to make this more testable"
    // "What would the unit tests look like after refactoring?"
}
