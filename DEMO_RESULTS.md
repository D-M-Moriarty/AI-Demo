# Demo Run 1 - Scenario 1: Factory + Strategy Refactoring

**Time**: 14:30 - 14:33
**Audience**: Practice Run (AI Assistant Demo)
**Group Size**: 1

## Prompt 1: Opening Problem Identification
```
I have this OrderProcessor class that started simple but has grown into a monster. It handles data loading, processing, and formatting all in one place. Can you explain what's wrong with this design and how I should refactor it?
```

**Copilot Response:**
```
This OrderProcessor class is a classic example of a "God Class" that violates several SOLID principles:

**Problems identified:**
1. **Single Responsibility Principle (SRP) violation**: The class handles multiple responsibilities:
   - Data loading from different sources (CSV, JSON, XML, Database)
   - Data processing with different algorithms (analytics, transformation, validation, aggregation)
   - Output formatting for different formats
   - Logging and metrics

2. **Open/Closed Principle (OCP) violation**: Adding new data types or processing methods requires modifying the existing class

3. **High coupling**: All functionality is tightly coupled in one class, making it hard to test and maintain

4. **Code duplication**: Similar switch statements appear multiple times

**Refactoring suggestions:**
- Extract data loading into separate classes (one per data source type)
- Extract processing logic into strategy classes
- Use factory patterns to create appropriate handlers
- Separate concerns into focused, single-responsibility classes
```

**Notes:**
- Quality of problem identification: ⭐⭐⭐⭐⭐
- Did it mention specific SOLID violations? Y - Very detailed
- Surprising insights: Excellent identification of code duplication in switch statements

---

## Prompt 2: SOLID Principles Discussion
```
This class violates SOLID principles. How would you break it down using design patterns?
```

**Copilot Response:**
```
Here's how to apply design patterns to fix the SOLID violations:

**1. Strategy Pattern for Processing Logic:**
```java
interface ProcessingStrategy {
    Object process(Object data);
}

class AnalyticsProcessor implements ProcessingStrategy { ... }
class TransformationProcessor implements ProcessingStrategy { ... }
```

**2. Factory Pattern for Data Sources:**
```java
interface DataSource {
    Object loadData(List<String> rawData);
    String formatOutput(Object processedData);
}

class DataSourceFactory {
    public static DataSource getDataSource(String type) { ... }
}
```

**3. Dependency Inversion:**
- Depend on abstractions (interfaces) not concrete classes
- Inject dependencies rather than creating them directly

**Benefits:**
- Each class has a single responsibility
- Easy to add new processing types without modifying existing code
- Each component can be tested independently
- Better separation of concerns
```

**Notes:**
- Which patterns suggested: Strategy, Factory, Dependency Inversion
- How detailed was explanation: ⭐⭐⭐⭐⭐
- Audience reaction: Very clear explanation with concrete code examples

---

## Prompt 3: Factory + Strategy Implementation
```
I'm thinking factory pattern for the data sources and strategy pattern for processing. Walk me through that approach and show me the implementation.
```

**Copilot Response:**
```
Perfect combination! Here's the complete implementation:

**Step 1: Define Strategy Interface**
```java
public interface ProcessingStrategy {
    Object process(Object data);
}
```

**Step 2: Concrete Strategy Implementations**
```java
public class AnalyticsProcessor implements ProcessingStrategy {
    @Override
    public Object process(Object data) {
        // Analytics-specific logic
        return "Analytics result for: " + data.toString();
    }
}

public class TransformationProcessor implements ProcessingStrategy {
    @Override
    public Object process(Object data) {
        // Transformation logic
        return "Transformed: " + data.toString();
    }
}
```

**Step 3: Data Source Interface and Implementations**
```java
public interface DataSource {
    Object loadData(List<String> rawData);
    String formatOutput(Object processedData);
}

public class CsvDataSource implements DataSource {
    @Override
    public Object loadData(List<String> rawData) {
        // CSV-specific loading logic
        return new HashMap<String, Object>() {{
            put("type", "csv");
            put("rows", rawData.size());
        }};
    }
    
    @Override
    public String formatOutput(Object processedData) {
        return "CSV Output: " + processedData.toString();
    }
}
```

**Step 4: Factory Classes**
```java
public class DataSourceFactory {
    private static final Map<String, DataSource> sources = new HashMap<>();
    
    static {
        sources.put("csv", new CsvDataSource());
        sources.put("json", new JsonDataSource());
        // ... other sources
    }
    
    public static DataSource getDataSource(String type) {
        DataSource source = sources.get(type.toLowerCase());
        if (source == null) {
            throw new IllegalArgumentException("Unsupported data type: " + type);
        }
        return source;
    }
}

public class ProcessingStrategyFactory {
    private static final Map<String, ProcessingStrategy> strategies = new HashMap<>();
    
    static {
        strategies.put("analytics", new AnalyticsProcessor());
        strategies.put("transformation", new TransformationProcessor());
        // ... other strategies
    }
    
    public static ProcessingStrategy getStrategy(String type) {
        ProcessingStrategy strategy = strategies.get(type.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported processing type: " + type);
        }
        return strategy;
    }
}
```

**Step 5: Refactored Main Class**
```java
public class RefactoredDataProcessor {
    public String processData(String dataType, String processingType, List<String> rawData) {
        // Use factories to get appropriate implementations
        DataSource dataSource = DataSourceFactory.getDataSource(dataType);
        ProcessingStrategy processor = ProcessingStrategyFactory.getStrategy(processingType);
        
        // Clean workflow: load → process → format
        Object loadedData = dataSource.loadData(rawData);
        Object processedData = processor.process(loadedData);
        return dataSource.formatOutput(processedData);
    }
}
```

**Key Benefits:**
- Main class went from 156 lines to ~43 lines
- Adding new processing type = create one new class
- Each component is independently testable
- Zero modification needed to existing code when extending
```

**Generated Code Files:**
- [x] Save any .java files generated in this folder

**Notes:**
- Code quality vs. my refactored solution: ⭐⭐⭐⭐⭐ - Very similar approach!
- Differences in approach: Almost identical, slightly different HashMap initialization style
- Better/worse design decisions: Excellent design, matches best practices perfectly

---

## Prompt 4: Benefits Discussion
```
How would this refactored design make the code more testable and maintainable?
```

**Copilot Response:**
```
The refactored design dramatically improves testability and maintainability:

**Testability Improvements:**

1. **Unit Testing Each Component:**
```java
@Test
void testAnalyticsProcessor() {
    ProcessingStrategy processor = new AnalyticsProcessor();
    Object result = processor.process("test data");
    assertEquals("Analytics result for: test data", result);
}

@Test
void testCsvDataSource() {
    DataSource source = new CsvDataSource();
    Object loaded = source.loadData(Arrays.asList("row1", "row2"));
    // Test just the CSV loading logic
}
```

2. **Mocking Dependencies:**
```java
@Test
void testMainProcessor() {
    // Mock the factories or inject test implementations
    DataSource mockSource = mock(DataSource.class);
    ProcessingStrategy mockProcessor = mock(ProcessingStrategy.class);
    
    // Test the main workflow without external dependencies
}
```

3. **Testing Edge Cases:** Each component can be tested for specific edge cases without setting up the entire system

**Maintainability Improvements:**

1. **Single Responsibility:** Each class has one reason to change
2. **Open/Closed:** Add new features without modifying existing code
3. **Easier Debugging:** Issues can be isolated to specific components
4. **Code Reuse:** Strategies and data sources can be reused in other contexts
5. **Team Development:** Different developers can work on different components simultaneously

**Real-world Example:**
Adding support for Parquet files now requires:
- One new `ParquetDataSource` class
- One line in `DataSourceFactory`
- Zero changes to existing code
- Independent unit tests for just the Parquet functionality

Compare this to the original God class where adding Parquet would require modifying the main class in multiple places, potentially breaking existing functionality.
```

**Notes:**
- Quality of testing discussion: ⭐⭐⭐⭐⭐
- Concrete examples provided: Y - Excellent code examples and real-world scenarios

---

## Overall Run Notes
**What worked well:**
- Copilot immediately identified this as a "God Class" - great technical vocabulary
- Provided complete, compilable code examples
- Excellent progression from problem identification to full solution
- Testing discussion was very practical with concrete examples

**What to improve:**
- Could spend more time on the "before vs after" comparison
- Maybe show the line count reduction more dramatically
- Could ask follow-up about dependency injection

**Audience questions:**
- "How does this compare to your actual refactored solution?"
- "Would this approach work with Spring dependency injection?"
- "What about performance implications of the factory pattern?"

**Time taken:** 3.5 minutes (slightly over, but great content)

