---
mode: 'edit'
description: 'Analyze legacy code and implement comprehensive refactoring with design patterns'
---

# Legacy Code Refactoring Implementation

Analyze the legacy code using the codebase tool, then implement comprehensive refactoring following SOLID principles and design patterns.

## Implementation Requirements:
- **Code Analysis**: Identify violations of SOLID principles
- **Design Pattern Implementation**: Apply appropriate patterns (Factory, Strategy, Observer, etc.)
- **File Creation**: Create new refactored classes and interfaces
- **Code Migration**: Update existing code to use new patterns
- **Preserve Functionality**: Ensure all existing behavior is maintained

## Implementation Steps:
1. **Analysis Phase**: Review current code structure and identify issues
2. **Design Phase**: Plan the refactored architecture with design patterns
3. **Implementation Phase**: Create new files and refactor existing ones
4. **Verification Phase**: Ensure tests still pass and functionality is preserved

## Focus Areas:
1. **Single Responsibility**: Split large classes into focused components
2. **Open/Closed**: Implement extensible patterns
3. **Dependency Inversion**: Create abstractions and interfaces
4. **Code Duplication**: Extract common functionality
5. **Testability**: Make code easier to unit test

## Target Analysis
Analyze the code in `${file}` or use `${selection}` if specific code is selected.

## Workspace Context
Working in: `${workspaceFolder}`
Project: `${workspaceFolderBasename}`

## Prerequisites
Follow the guidelines in [code-analysis.prompt.md](./code-analysis.prompt.md) before proceeding.

## Testing Strategy
Apply the testing patterns from [test-generation.prompt.md](./test-generation.prompt.md).

Create all necessary new files and modify existing ones to implement the refactoring.
