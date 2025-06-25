---
mode: 'agent'
tools: ['changes', 'codebase', 'editFiles', 'extensions', 'fetch', 'findTestFiles', 'githubRepo', 'new', 'openSimpleBrowser', 'problems', 'runCommands', 'runNotebooks', 'runTasks', 'search', 'searchResults', 'terminalLastCommand', 'terminalSelection', 'testFailure', 'usages', 'vscodeAPI', 'atlassian', 'configurePythonEnvironment', 'getPythonEnvironmentInfo', 'getPythonExecutableCommand', 'installPythonPackage', 'get_syntax_docs', 'mermaid-diagram-preview', 'mermaid-diagram-validator']
description: 'Generate comprehensive unit tests following team testing standards'
---

# Comprehensive Test Generation Agent

Analyze the provided class and generate comprehensive unit tests following our team's testing standards and best practices.

## Testing Requirements:
- **Test Coverage**: Aim for 90%+ line and branch coverage
- **Test Categories**: Happy path, edge cases, boundary values, error conditions
- **Framework**: Use JUnit 5 with appropriate assertions and annotations
- **Structure**: Follow AAA pattern (Arrange, Act, Assert)
- **Naming**: Use descriptive test method names that explain the scenario

## Test Generation Guidelines:

### **Test Class Structure**:
- Create test class with `Test` suffix matching the class under test
- Use `@DisplayName` annotations for readable test descriptions
- Group related tests using `@Nested` inner classes when appropriate
- Include setup and teardown methods (`@BeforeEach`, `@AfterEach`) as needed

### **Test Scenarios to Cover**:

#### **1. Happy Path Tests**:
- Normal input values and expected workflows
- Standard use cases and common scenarios
- Valid parameter combinations

#### **2. Edge Cases**:
- Null input parameters
- Empty collections/strings
- Zero and negative values where applicable
- Minimum and maximum boundary values

#### **3. Error Conditions**:
- Invalid input parameters
- Illegal state scenarios
- Exception throwing conditions with proper `@Test(expected = ...)` or `assertThrows()`

#### **4. Business Logic Validation**:
- Verify calculations and transformations
- Test conditional logic branches
- Validate state changes and side effects

### **Code Quality Standards**:
- **Mock Dependencies**: Use Mockito for external dependencies
- **Test Data**: Create meaningful test data that represents real scenarios
- **Assertions**: Use specific assertions (`assertEquals`, `assertTrue`, `assertNotNull`, etc.)
- **Documentation**: Include comments for complex test scenarios
- **Independence**: Each test should be independent and repeatable

### **Performance and Integration**:
- Include performance tests for critical methods when applicable
- Test thread safety for concurrent operations
- Validate resource cleanup and memory management

## Deliverables:
- **Complete Test Class**: Fully functional test class with all imports
- **Test Methods**: Individual test methods for each scenario
- **Mock Setup**: Proper mocking of dependencies where needed
- **Data Providers**: Test data setup methods or constants
- **Documentation**: Clear comments explaining complex test logic

## Example Test Structure:
```java
@DisplayName("DataProcessor Tests")
class DataProcessorTest {
    
    @BeforeEach
    void setUp() {
        // Test setup
    }
    
    @Nested
    @DisplayName("Process Data Tests")
    class ProcessDataTests {
        
        @Test
        @DisplayName("Should process valid CSV data successfully")
        void shouldProcessValidCsvDataSuccessfully() {
            // Arrange
            // Act
            // Assert
        }
        
        @Test
        @DisplayName("Should throw exception when data type is null")
        void shouldThrowExceptionWhenDataTypeIsNull() {
            // Test exception scenario
        }
    }
}
```

## Quality Metrics:
- **Readability**: Tests should be self-documenting
- **Maintainability**: Easy to update when code changes
- **Reliability**: Tests should be deterministic and stable
- **Completeness**: Cover all public methods and critical paths

Generate tests that would pass code review and provide confidence in the code quality. Focus on practical test scenarios that catch real bugs and regressions.
