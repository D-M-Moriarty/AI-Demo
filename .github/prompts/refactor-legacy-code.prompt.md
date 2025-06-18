---
mode: 'agent'
tools: ['codebase', 'githubSearch']
description: 'Analyze legacy code and provide comprehensive refactoring recommendations'
---

# Legacy Code Refactoring Agent

Use the codebase tool to analyze the legacy code and provide comprehensive refactoring recommendations following SOLID principles and design patterns.

## Analysis Requirements:
- **Code Review**: Identify violations of SOLID principles
- **Design Pattern Opportunities**: Suggest appropriate patterns (Factory, Strategy, Observer, etc.)
- **Refactoring Plan**: Step-by-step implementation approach
- **Impact Assessment**: Benefits, risks, and migration strategy
- **Code Examples**: Concrete implementation samples

## Focus Areas:
1. **Single Responsibility**: Classes doing too much
2. **Open/Closed**: Hard-coded logic that should be extensible
3. **Dependency Inversion**: Tight coupling issues
4. **Code Duplication**: Repeated logic that can be abstracted
5. **Testability**: Areas difficult to unit test

## Deliverables:
- **Problem Analysis**: What's wrong with current implementation
- **Proposed Solution**: Design pattern implementation
- **Refactored Code**: Complete working examples
- **Testing Strategy**: How to verify the refactoring works
- **Migration Path**: How to safely transition from old to new

Use the githubSearch tool if you need to reference common design pattern implementations or best practices.
