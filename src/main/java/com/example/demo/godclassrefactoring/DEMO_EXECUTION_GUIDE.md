# Scenario 1 Demo Script: Before/After Code Execution

## Quick Before/After Demonstration

### Option 1: Using DemoRunner (Recommended - 30 seconds)

**Action**: Run in terminal
```bash
mvn exec:java -Dexec.mainClass="com.example.demo.DemoRunner"
```

**What audience sees**:
- Same input data processed by both versions
- Identical outputs proving functionality is preserved
- Clear visual comparison of legacy vs refactored

**Talking points while it runs**:
> "Let me show you both versions work identically. Same input, same output - but the refactored version is much cleaner to maintain."

### Option 2: Live Coding Demo (1 minute)

**Step 1**: Open terminal in VS Code

**Step 2**: Run legacy version
```bash
# In VS Code terminal or external terminal
cd /home/fexco.ie/dmoriarty/Development/sandbox/AI-Demo
mvn compile
mvn exec:java -Dexec.args="scenario1-legacy"
```

**Step 3**: Run refactored version  
```bash
mvn exec:java -Dexec.args="scenario1-refactored"
```

**Talking points**:
> "Notice both produce identical results. The refactoring preserved all functionality while dramatically improving the code structure."

### Option 3: Quick Manual Test (45 seconds)

**Action**: In VS Code, create a quick test in the terminal:

```java
// You can paste this into jshell or create a quick test
DataProcessor legacy = new DataProcessor();
RefactoredDataProcessor refactored = new RefactoredDataProcessor();

List<String> data = Arrays.asList("test1", "test2");
String result1 = legacy.processData("csv", "analytics", data);
String result2 = refactored.processData("csv", "analytics", data);

System.out.println("Legacy: " + result1);
System.out.println("Refactored: " + result2);
System.out.println("Same result: " + result1.equals(result2));
```

## Integration with Main Demo Script

### When to use this:
- **During Scenario 1** - after Copilot gives refactoring advice
- **Before showing refactored code** - prove the old version works
- **After showing refactored code** - prove they work the same

### Smooth transition:
> "Before we implement Copilot's suggestions, let me show you the current code actually works..."
> [Run demo]
> "Now let's look at the refactored version I built using Copilot's advice..."
> [Show refactored code]
> "And you can see it produces identical results with much cleaner architecture."

### Time management:
- **If running long**: Use Option 1 (DemoRunner) - fastest
- **If audience is technical**: Use Option 2 - shows build process
- **If need to be quick**: Skip this and just mention "I've verified both work identically"

## Expected Output

```
=== Scenario 1: Before/After Comparison ===

🔴 LEGACY (God Class) - DataProcessor:
   Input: [row1,value1, row2,value2, row3,value3]
   Output: CSV Output: Analytics result for: {type=csv, rows=3}

🟢 REFACTORED (Factory + Strategy) - RefactoredDataProcessor:
   Input: [row1,value1, row2,value2, row3,value3]  
   Output: CSV Output: Analytics result for: {type=csv, rows=3}

✅ Results match: true
💡 Same functionality, cleaner architecture!
```

This clearly demonstrates that refactoring preserved functionality while improving design.
