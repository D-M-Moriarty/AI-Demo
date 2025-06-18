# GitHub Copilot Demo - Java Data Processing System

A comprehensive Java demonstration project showcasing real-world data processing patterns, design principles, and GitHub Copilot integration workflows. This project serves as a practical example for demonstrating Copilot's capabilities in code explanation, refactoring, documentation generation, and debugging.

## 🎯 Project Overview

This project demonstrates three core scenarios commonly encountered in enterprise software development:

### 🏗️ Scenario 1: Legacy Code Refactoring
- **Problem**: Monolithic "God class" that violates SOLID principles
- **Solution**: Clean Factory + Strategy pattern implementation
- **Features**: 
  - Multiple data source types (CSV, JSON, XML, Database)
  - Pluggable processing strategies (Analytics, Transformation, Validation, Aggregation)
  - Full SOLID principles compliance
  - Comprehensive unit testing

### � Scenario 2: Project README Generation
- **Complex Codebase Analysis**: Multi-scenario project for README generation
- **Features**:
  - Automatic project structure analysis
  - Professional documentation generation from code
  - Multiple audience targeting (developers, stakeholders, users)
  - Installation, usage, and architecture documentation

### ⚡ Scenario 3: Cache Implementation & Debugging
- **Problem**: Buggy cache with threading and memory issues
- **Features**:
  - Generic cache with TTL (Time-To-Live) support
  - Configurable size limits and eviction policies
  - Thread-safety challenges for debugging practice
  - Performance optimization opportunities

## 🚀 Quick Start

### Prerequisites
- **Java 11** or higher
- **Maven 3.6+** 
- **VS Code** with Java Extension Pack (recommended for Copilot demos)

### Installation & Setup

1. **Clone and Build**:
   ```bash
   git clone <repository-url>
   cd AI-Demo
   mvn clean compile
   ```

2. **Run the Demo**:
   ```bash
   # Run all scenarios
   mvn exec:java -Dexec.mainClass="com.example.demo.DemoRunner"
   
   # Or run with Maven
   mvn exec:java
   ```

3. **Run Tests**:
   ```bash
   # Run all tests
   mvn test
   
   # Run specific scenario tests
   mvn test -Dtest="*Scenario1*"
   mvn test -Dtest="*BuggyCache*"
   ```

## 📖 Usage Examples

### Scenario 1: Data Processing

#### Legacy Approach (Monolithic)
```java
DataProcessor legacyProcessor = new DataProcessor();
String result = legacyProcessor.processData("csv", "analytics", dataList);
System.out.println(result);
```

#### Refactored Approach (Clean Architecture)
```java
RefactoredDataProcessor processor = new RefactoredDataProcessor();
String result = processor.processData("json", "transformation", dataList);
System.out.println(result);
```

### Scenario 2: Transaction Processing
```java
DataProcessor processor = new DataProcessor();
List<Transaction> transactions = Arrays.asList(
    new Transaction("T1", "food", 25.50, "USD", LocalDateTime.now()),
    new Transaction("T2", "electronics", 299.99, "EUR", LocalDateTime.now())
);

// Process and convert to USD
List<TransactionSummary> summaries = processor.processTransactions(transactions, "USD");
summaries.forEach(summary -> 
    System.out.println(summary.getCategory() + ": $" + summary.getTotalWithTax())
);
```

### Scenario 3: Caching (with bugs to debug)
```java
BuggyCache<String, String> cache = new BuggyCache<>(100, 5000);

// Basic operations
cache.put("user:123", "John Doe");
String user = cache.get("user:123");

// Performance monitoring
System.out.println("Cache size: " + cache.size());
Map<String, String> allValid = cache.getAllValid();
```

## 🏗️ Architecture

### Design Patterns Demonstrated

1. **Factory Pattern** (`DataSourceFactory`, `ProcessingStrategyFactory`)
   - Centralized object creation
   - Type safety and extensibility
   - Easy testing and mocking

2. **Strategy Pattern** (`ProcessingStrategy`, `DataSource`)
   - Pluggable algorithms
   - Runtime behavior selection
   - Clean separation of concerns

3. **Template Method** (in refactored processors)
   - Consistent workflow structure
   - Extensible processing pipeline

### Project Structure
```
src/main/java/com/example/demo/
├── DemoRunner.java          # Main entry point for demonstrations
├── scenario1/               # Factory + Strategy Pattern Demo
│   ├── DataProcessor.java   # Legacy monolithic class (anti-pattern)
│   ├── OrderProcessor.java  # Alternative legacy example
│   └── refactored/          # Clean implementation with patterns
│       ├── DataSource.java
│       ├── ProcessingStrategy.java
│       ├── Factories.java
│       └── RefactoredDataProcessor.java
├── scenario2/               # Financial Processing Demo
│   ├── DataProcessor.java   # Complex financial algorithms
│   ├── Transaction.java     # Domain model
│   └── TransactionSummary.java
└── scenario3/               # Debugging Demo
    └── BuggyCache.java      # Intentionally buggy cache implementation

src/test/java/               # Comprehensive test suite
├── scenario1/
├── scenario2/
└── scenario3/
```

## 🧪 Testing

The project includes comprehensive tests demonstrating:

- **Unit Testing**: Individual component testing
- **Integration Testing**: Cross-component workflows  
- **Edge Case Testing**: Boundary conditions and error scenarios
- **Performance Testing**: Cache behavior under load
- **Thread Safety Testing**: Concurrent access patterns

### Running Specific Tests
```bash
# Test the legacy vs refactored implementations
mvn test -Dtest="DataProcessorTest"
mvn test -Dtest="OrderProcessorTest"

# Test transaction processing
mvn test -Dtest="*Transaction*"

# Test cache implementation (will reveal bugs)
mvn test -Dtest="BuggyCacheTest"
```

## 🚀 Extension Points

### Adding New Data Sources
1. Implement the `DataSource` interface
2. Register in `DataSourceFactory`
3. Add corresponding tests

```java
public class NewDataSource implements DataSource {
    @Override
    public Object loadData(List<String> rawData) { /* implementation */ }
    
    @Override
    public String formatOutput(Object processedData) { /* implementation */ }
}
```

### Adding New Processing Strategies
1. Implement the `ProcessingStrategy` interface
2. Register in `ProcessingStrategyFactory`
3. Add unit tests for the new strategy

```java
public class CustomProcessor implements ProcessingStrategy {
    @Override
    public Object process(Object data) { /* implementation */ }
}
```

## 🎓 Demo Scenarios

This project is specifically designed for GitHub Copilot demonstrations:

### Scenario 1: Code Refactoring
- **Prompt**: "This class violates SOLID principles. How would you refactor it using design patterns?"
- **Outcome**: Learn Factory + Strategy pattern implementation
- **Time**: 3-4 minutes

### Scenario 2: Project README Generation  
- **Prompt**: "Analyze this codebase and generate a comprehensive README.md file"
- **Outcome**: Auto-generated professional project documentation from code analysis
- **Time**: 2-3 minutes

### Scenario 3: Bug Detection & Debugging
- **Prompt**: "Help me find bugs in this cache implementation"
- **Outcome**: Identify threading issues, memory leaks, and race conditions
- **Time**: 3-4 minutes

## 🔧 Configuration

### Currency Conversion Rates
Edit `DataProcessor.initializeConversionRates()` to modify currency pairs:
```java
conversionRates.put("USD_EUR", 0.85);
conversionRates.put("USD_GBP", 0.73);
// Add more currency pairs as needed
```

### Tax Rates by Category
Modify `calculateTaxRate()` method for different tax policies:
```java
case "food": return 0.05;        // 5% tax on food
case "electronics": return 0.15; // 15% tax on electronics
```

### Cache Configuration
Adjust cache parameters in `BuggyCache` constructor:
```java
BuggyCache<K, V> cache = new BuggyCache<>(
    maxSize: 1000,     // Maximum number of entries
    ttlMillis: 300000  // 5 minutes TTL
);
```

## 🤝 Contributing

This project follows standard Java development practices:

1. **Code Style**: Standard Java conventions with clear naming
2. **Testing**: Comprehensive unit tests for all components
3. **Documentation**: JavaDoc for public APIs
4. **Build Tool**: Maven for dependency management and builds

### Development Workflow
```bash
# Make changes
git checkout -b feature/your-feature

# Test your changes
mvn clean test

# Build and verify
mvn clean package

# Submit pull request
git push origin feature/your-feature
```

## 📊 Performance Considerations

- **Data Processing**: Optimized for datasets up to 10,000 records
- **Memory Usage**: Configurable cache limits prevent memory exhaustion  
- **Threading**: Cache implementation demonstrates concurrency challenges
- **Scalability**: Factory pattern enables easy horizontal scaling

## 🐛 Known Issues (Intentional for Demo)

The `BuggyCache` class contains several intentional bugs for debugging demonstrations:

1. **Race Conditions**: `evictExpired()` method has threading issues
2. **Memory Leaks**: Size limit enforcement is incomplete
3. **Performance**: Inefficient eviction strategy
4. **Error Handling**: Missing validation and exception handling

## 📄 License

This project is intended for educational and demonstration purposes.

---

**Built for GitHub Copilot Demonstrations** - Showcasing AI-powered development workflows
