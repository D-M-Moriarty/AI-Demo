# GitHub Copilot Instructions for Java Demo Project

This is a Java demonstration project for showcasing GitHub Copilot Chat capabilities across three core scenarios: legacy code refactoring, project documentation, and debugging.

## Project Context
- **Language**: Java 11+
- **Build Tool**: Maven
- **Testing Framework**: JUnit 5
- **Architecture**: Demonstrates Factory + Strategy patterns, data processing, and caching
- **Purpose**: Live demonstration of Copilot Chat workflows and team collaboration

## Code Style Preferences
- Use clear, descriptive variable and method names
- Include JavaDoc comments for public methods and classes
- Follow standard Java naming conventions (PascalCase for classes, camelCase for methods)
- Prefer explicit over implicit when it aids readability
- Use meaningful exception messages and proper error handling

## Design Pattern Guidelines
- **Factory Pattern**: Use for object creation when type is determined at runtime
- **Strategy Pattern**: Implement for algorithms that can vary independently
- **Single Responsibility**: Each class should have one reason to change
- **Open/Closed**: Classes open for extension, closed for modification

## Demo-Specific Instructions

### Scenario 1: Legacy Code Refactoring
- Focus on SOLID principle violations in monolithic classes
- Suggest concrete design patterns with implementation examples
- Provide step-by-step refactoring plans
- Emphasize testability and maintainability improvements

### Scenario 2: Project Documentation
- Generate comprehensive README files with professional structure
- Include installation, usage, and architecture sections
- Target multiple audiences (developers, contributors, stakeholders)
- Emphasize time savings and documentation quality

### Scenario 3: Debugging and Problem Solving
- Identify threading issues, race conditions, and memory leaks
- Explain technical reasoning behind each identified issue
- Prioritize issues by severity (High/Medium/Low)
- Provide concrete fix recommendations with code examples

## Response Guidelines
- Always provide concrete, actionable code examples
- Explain the reasoning behind suggestions
- Focus on practical, real-world solutions
- Consider the demonstration context and audience impact
2. **Test Generation**: Generate comprehensive unit tests with edge cases
3. **Code Refactoring**: Improve existing code structure and readability
4. **Bug Fixing**: Help identify and resolve issues in the codebase
5. **Documentation**: Generate or improve JavaDoc comments

## Demonstration Scenarios
This project is specifically designed for live demonstrations of:
- How Copilot Chat explains existing code
- Generating unit tests from existing methods
- Refactoring and optimization suggestions
- Debugging assistance through conversational AI
