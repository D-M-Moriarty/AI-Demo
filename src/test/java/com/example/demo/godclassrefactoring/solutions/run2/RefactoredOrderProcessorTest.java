package com.example.demo.godclassrefactoring.solutions.run2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Comprehensive unit tests for the RefactoredOrderProcessor.
 * Demonstrates the testability benefits of the refactored design.
 */
@DisplayName("Refactored Order Processor Tests")
class RefactoredOrderProcessorTest {
    
    private RefactoredOrderProcessor processor;
    private List<String> testData;
    
    @BeforeEach
    void setUp() {
        processor = new RefactoredOrderProcessor();
        testData = Arrays.asList("data1", "data2", "data3");
    }
    
    @Test
    @DisplayName("Should process CSV data with analytics successfully")
    void shouldProcessCsvWithAnalytics() {
        String result = processor.processData("csv", "analytics", testData);
        
        assertNotNull(result);
        assertTrue(result.contains("CSV Output"));
        assertTrue(result.contains("Analytics result"));
    }
    
    @Test
    @DisplayName("Should process JSON data with transformation successfully")
    void shouldProcessJsonWithTransformation() {
        String result = processor.processData("json", "transformation", testData);
        
        assertNotNull(result);
        assertTrue(result.contains("JSON Output"));
        assertTrue(result.contains("Transformed"));
    }
    
    @Test
    @DisplayName("Should process XML data with validation successfully")
    void shouldProcessXmlWithValidation() {
        String result = processor.processData("xml", "validation", testData);
        
        assertNotNull(result);
        assertTrue(result.contains("XML Output"));
        assertTrue(result.contains("Validated"));
    }
    
    @Test
    @DisplayName("Should process database data with aggregation successfully")
    void shouldProcessDatabaseWithAggregation() {
        String result = processor.processData("database", "aggregation", testData);
        
        assertNotNull(result);
        assertTrue(result.contains("Database Output"));
        assertTrue(result.contains("Aggregated"));
    }
    
    @Test
    @DisplayName("Should throw exception for unsupported data type")
    void shouldThrowExceptionForUnsupportedDataType() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> processor.processData("unsupported", "analytics", testData)
        );
        
        assertTrue(exception.getMessage().contains("Unsupported data type"));
    }
    
    @Test
    @DisplayName("Should throw exception for unsupported processing type")
    void shouldThrowExceptionForUnsupportedProcessingType() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> processor.processData("csv", "unsupported", testData)
        );
        
        assertTrue(exception.getMessage().contains("Unsupported processing type"));
    }
    
    @Test
    @DisplayName("Should return available data types")
    void shouldReturnAvailableDataTypes() {
        String[] dataTypes = processor.getAvailableDataTypes();
        
        assertNotNull(dataTypes);
        assertTrue(dataTypes.length > 0);
        assertTrue(Arrays.asList(dataTypes).contains("csv"));
        assertTrue(Arrays.asList(dataTypes).contains("json"));
        assertTrue(Arrays.asList(dataTypes).contains("xml"));
        assertTrue(Arrays.asList(dataTypes).contains("database"));
    }
    
    @Test
    @DisplayName("Should return available processing types")
    void shouldReturnAvailableProcessingTypes() {
        String[] processingTypes = processor.getAvailableProcessingTypes();
        
        assertNotNull(processingTypes);
        assertTrue(processingTypes.length > 0);
        assertTrue(Arrays.asList(processingTypes).contains("analytics"));
        assertTrue(Arrays.asList(processingTypes).contains("transformation"));
        assertTrue(Arrays.asList(processingTypes).contains("validation"));
        assertTrue(Arrays.asList(processingTypes).contains("aggregation"));
    }
    
    @Test
    @DisplayName("Should return available output formats")
    void shouldReturnAvailableOutputFormats() {
        String[] outputFormats = processor.getAvailableOutputFormats();
        
        assertNotNull(outputFormats);
        assertTrue(outputFormats.length > 0);
        assertTrue(Arrays.asList(outputFormats).contains("csv"));
        assertTrue(Arrays.asList(outputFormats).contains("json"));
        assertTrue(Arrays.asList(outputFormats).contains("xml"));
        assertTrue(Arrays.asList(outputFormats).contains("database"));
    }
    
    @Test
    @DisplayName("Should handle empty data list")
    void shouldHandleEmptyDataList() {
        List<String> emptyData = Arrays.asList();
        
        String result = processor.processData("csv", "analytics", emptyData);
        
        assertNotNull(result);
        assertTrue(result.contains("CSV Output"));
    }
    
    @Test
    @DisplayName("Should handle case insensitive data types")
    void shouldHandleCaseInsensitiveDataTypes() {
        String result1 = processor.processData("CSV", "analytics", testData);
        String result2 = processor.processData("csv", "analytics", testData);
        
        assertNotNull(result1);
        assertNotNull(result2);
        // Both should work and produce similar results
        assertTrue(result1.contains("CSV Output"));
        assertTrue(result2.contains("CSV Output"));
    }
    
    @Test
    @DisplayName("Should handle case insensitive processing types")
    void shouldHandleCaseInsensitiveProcessingTypes() {
        String result1 = processor.processData("csv", "ANALYTICS", testData);
        String result2 = processor.processData("csv", "analytics", testData);
        
        assertNotNull(result1);
        assertNotNull(result2);
        // Both should work and produce similar results
        assertTrue(result1.contains("Analytics result"));
        assertTrue(result2.contains("Analytics result"));
    }
}
