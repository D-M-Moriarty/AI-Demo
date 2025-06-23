# GitHub Copilot Demo - Java Project

A Java demonstration project designed for showcasing GitHub Copilot Chat capabilities.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6+

### Building the Project
```bash
mvn compile
```

### Running the Demo
```bash
mvn exec:java -Dexec.mainClass="com.example.demo.DemoRunner"
```

### Running Tests
```bash
mvn test
```

## Project Structure

```
src/
├── main/java/com/example/demo/
│   ├── DemoRunner.java          # Demo runner showing before/after refactoring
│   ├── godclassrefactoring/     # God class refactoring demonstration
│   │   ├── OrderProcessor.java  # Legacy god class (169 lines)
│   │   └── refactored/         # Clean factory + strategy implementation
│   ├── readmegeneration/       # Complex codebase for README generation
│   └── debugbuggycode/         # Buggy cache for debugging demonstration
└── test/java/com/example/demo/
    ├── godclassrefactoring/
    ├── debugbuggycode/
    └── [test files]
```

This project demonstrates GitHub Copilot Chat capabilities through focused scenarios:

## 🎯 **Main Demo: God Class Refactoring**

### Quick Demo (5 minutes)
1. **Open the god class**: `src/main/java/com/example/demo/godclassrefactoring/OrderProcessor.java`
2. **Analyze with Copilot**: `@refactor-legacy-code` (uses `.github/prompts/refactor-legacy-code.prompt.md`)
3. **Show the solution**: Explore the `refactored/` folder with clean factory + strategy patterns
4. **Prove it works**: Run `mvn exec:java -Dexec.mainClass="com.example.demo.DemoRunner"`

### Key Files
- **`OrderProcessor.java`** - 169-line god class with multiple responsibilities
- **`refactored/`** - Clean implementation using Factory + Strategy patterns  
- **`DemoRunner.java`** - Shows before/after comparison with identical output
- **`.github/prompts/refactor-legacy-code.prompt.md`** - Team standardized refactoring agent

## 🛠️ **Supporting Scenarios**

- **`readmegeneration/`** - Complex codebase for demonstrating README generation
- **`debugbuggycode/`** - Intentionally buggy cache for debugging demonstrations

## 💡 **Team Collaboration Features**

- **`.github/copilot-instructions.md`** - Workspace-specific Copilot guidelines
- **`.github/prompts/`** - Reusable prompt files for team standardization
