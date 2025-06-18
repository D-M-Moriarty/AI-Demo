# Scenario 3: Quick Problem Solving Prompts

## Demo Flow (2.5 minutes)

### 1. Opening Prompt (45 seconds)
```
I have this cache implementation that's causing issues in production. The tests are failing and I suspect there are threading problems. Can you help me identify the bugs?
```

### 2. Specific Issue Prompt (45 seconds)
```
Looking at this failing test, what specific issues do you see with the size limit enforcement?
```

### 3. Threading Focus Prompt (45 seconds)
```
What race conditions could occur in this cache implementation, especially in the evictExpired() method?
```

### 4. Solution Prompt (45 seconds)
```
How would you redesign this cache to be thread-safe and more reliable? Show me a better implementation.
```

## Backup Talking Points
- "Copilot quickly identified multiple categories of bugs: threading, logic, and performance"
- "Notice how it explains not just what's wrong, but why it's wrong"
- "This is like having a senior developer review my code instantly"
- "The suggested fixes address root causes, not just symptoms"

## Alternative Prompts (if needed)
```
Are there any memory leak issues in this cache implementation?
```

```
How would you add proper error handling to this cache?
```

```
What performance optimizations would you recommend for this cache?
```

```
Help me write comprehensive unit tests that would have caught these bugs.
```

## Context to Mention
- Point out the failing test in BuggyCacheTest.java
- Mention this represents real production issues you've encountered
- Show how the conversation helps you understand the problem deeper
