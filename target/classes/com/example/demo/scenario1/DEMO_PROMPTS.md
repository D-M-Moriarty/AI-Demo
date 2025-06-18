# Scenario 1: Factory + Strategy Refactoring Prompts

## Demo Flow (3 minutes)

### 1. Opening Prompt (30 seconds)
```
I have this DataProcessor class that started simple but has grown into a monster. It handles data loading, processing, and formatting all in one place. Can you explain what's wrong with this design and how I should refactor it?
```

### 2. Follow-up Prompt 1 (1 minute)
```
This class violates SOLID principles. How would you break it down using design patterns?
```

### 3. Follow-up Prompt 2 (1 minute)
```
I'm thinking factory pattern for the data sources and strategy pattern for processing. Walk me through that approach and show me the implementation.
```

### 4. Refinement Prompt (30 seconds)
```
How would this refactored design make the code more testable and maintainable?
```

## Backup Talking Points
- "Notice how the main class went from 125+ lines to just 20 focused lines"
- "Adding a new processing type now means creating one new class, not modifying existing ones"
- "Each component can be unit tested independently"
- "The workflow is now self-documenting: load → process → format"

## Alternative Prompts (if conversation goes differently)
```
That's a good start, but what if I also need to handle real-time data streams? How would you modify this design?
```

```
I like this approach, but my team prefers dependency injection. How would you adapt this pattern to work with a DI container?
```

```
Why did you choose this approach over using a simple if-else chain? What are the trade-offs I should consider?
```
