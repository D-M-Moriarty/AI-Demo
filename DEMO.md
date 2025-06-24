# 🎯 God Class Refactoring Demo

**Total Time: 5-7 minutes**

## 🚀 **Quick Setup**

1. **Open VS Code** with this project
2. **Open Copilot Chat** (`Ctrl+Shift+I` / `Cmd+Shift+I`)
3. **Have ready**: The god class file open

## 📋 **Demo Script**

### **1. Show the Problem (1 minute)**

**Open**: `src/main/java/com/example/demo/godclassrefactoring/OrderProcessor.java`

**Talking points:**
- "Here's a 169-line god class from a legacy system"
- "Multiple switch statements, does everything"
- "Hard to test, maintain, and extend"

### **2. Ask Copilot to Analyze (2 minutes)**

**In Copilot Chat, type exactly:**
```
#file:OrderProcessor.java #file:.github/prompts/refactor-legacy-code.prompt.md Analyze this legacy code using our team's refactoring standards from the prompt file.
```

**While it responds:**
- "This uses our team's standardized refactoring prompt file"
- "Notice how it identifies specific SOLID violations"
- "It's suggesting concrete design patterns like Factory and Strategy"

**Follow-up prompt:**
```
Show me the factory + strategy implementation with concrete code examples
```

### **3. Show the Solution (2 minutes)**

**Navigate to**: `src/main/java/com/example/demo/godclassrefactoring/refactored/`

**Show files:**
- `DataSourceFactory.java` - Factory pattern for data sources
- `ProcessingStrategyFactory.java` - Factory for processing strategies  
- `RefactoredDataProcessor.java` - Clean main class (20 lines vs 169!)

**Talking points:**
- "Each class has one responsibility"
- "Easy to add new data types or processing algorithms"
- "Much easier to test in isolation"

### **4. Prove it Works (1 minute)**

**Run the demo:**
```bash
mvn exec:java -Dexec.mainClass="com.example.demo.DemoRunner"
```

**While it runs:**
- "Same input, same output"
- "Refactoring didn't break functionality"
- "But the code is now maintainable and extensible"

### **5. Wrap Up (1 minute)**

**Key points:**
- "Copilot identified problems I might miss"
- "Suggested industry-standard patterns"
- "Team prompt files ensure consistent analysis"
- "From legacy mess to clean architecture in minutes"

## 🎪 **Demo Tips**

### **If Copilot gives different suggestions:**
- "Interesting! Let me show you one approach we've used successfully..."
- Navigate to the `refactored/` folder and explain the pattern

### **If you want to extend the demo:**
- Show the test files: much easier to test individual components
- Demonstrate adding a new data type: just implement the interface
- Compare lines of code: 169 → multiple focused 10-20 line classes

### **Backup plan:**
- Pre-built solution in `refactored/` folder
- Can walk through the pattern manually if needed

## 🔧 **Technical Details**

### **Files involved:**
- **Problem**: `OrderProcessor.java` (169 lines, multiple responsibilities)
- **Solution**: `refactored/` package (clean separation of concerns)
- **Demo**: `DemoRunner.java` (proves equivalence)
- **Prompt**: `.github/prompts/refactor-legacy-code.prompt.md` (team standards)

### **Patterns demonstrated:**
- Factory Pattern (for data source creation)
- Strategy Pattern (for processing algorithms)
- Dependency Injection (loose coupling)
- Single Responsibility Principle

### **Benefits shown:**
- Code maintainability
- Extensibility  
- Testability
- Team standardization through prompt files

---

**Remember**: This is a conversation with AI, not a script. React naturally to what Copilot suggests and let the audience see the genuine collaboration!
