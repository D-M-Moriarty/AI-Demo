# GitHub Copilot Chat Demo Guide - Multiple Runs

## Demo Structure (15 minutes total)
- **2 minutes**: Introduction 
- **8 minutes**: Live demo (3 scenarios)
- **3 minutes**: Q&A and wrap-up
- **2 minutes**: Regroup for next session

## Quick Setup Between Runs

### Before Each Demo Run:
1. **Determine run number** (1-10)
2. **Set up templates**: `./setup_run.sh <run_number>` (if not already done)
3. **Clear Copilot Chat history** 
4. **Open result files** for this run:
   - `scenario1/solutions/run<X>/DEMO_RESULTS.md`
   - `scenario2/solutions/run<X>/DEMO_RESULTS.md`
   - `scenario3/solutions/run<X>/DEMO_RESULTS.md`
5. **Fill in audience info** at top of each file

### During Demo:
- Copy-paste Copilot responses directly into the DEMO_RESULTS.md files
- Save any generated code files in the same `run<X>` folders
- Rate responses with star ratings ⭐⭐⭐⭐⭐
- Note audience reactions and surprising moments

### Between Sessions (2 minutes):
- Save and close current run files
- Quick review: what worked well/what to improve
- Setup next run: `./setup_run.sh <next_number>`

## Solution Folder Structure
```
scenario1/solutions/
├── run1/ - First demo session
├── run2/ - Second demo session  
├── run3/ - Third demo session
└── ...up to run10/

Each run folder contains:
├── DEMO_RESULTS.md - Complete capture of prompts, responses, and notes
└── [any generated .java files]
```

## Pre-Demo Checklist
- [ ] Open VS Code with this project
- [ ] Clear Copilot Chat history
- [ ] Have all three scenario files open in tabs:
  - `scenario1/DataProcessor.java`
  - `scenario2/DataProcessor.java` 
  - `scenario3/BuggyCache.java`
- [ ] Have prompt files ready:
  - `scenario1/DEMO_PROMPTS.md`
  - `scenario2/DEMO_PROMPTS.md`
  - `scenario3/DEMO_PROMPTS.md`
- [ ] Test that failing test runs: `mvn test`

## Demo Flow

### Introduction (2 minutes)
- "I'm a chat-first Copilot user - autocomplete disabled"
- "You'll see 3 real scenarios from my daily workflow"
- "This is about conversation and collaboration, not just code generation"

### Scenario 1: Factory + Strategy Refactoring (3 minutes)
**File**: `scenario1/DataProcessor.java`
**Backup solution**: `scenario1/refactored/` package
**Key point**: "I use it to explore different architectural approaches"

### Scenario 2: Project README Generation (2.5 minutes)  
**File**: `scenario2/DataProcessor.java` (complex codebase for analysis)
**Key point**: "Analyzes entire project to generate professional README - saves hours while improving quality"

### Scenario 3: Quick Problem Solving (2.5 minutes)
**File**: `scenario3/BuggyCache.java` + failing test
**Key point**: "Like having a senior developer review my code instantly"

## Recording Solutions
1. Copy-paste Copilot responses into the appropriate `solutions/X/README.md` files
2. Save any generated code files in the same numbered folders
3. Add your notes about quality, accuracy, and surprises

## Backup Plans
- If Copilot generates different code than expected, compare with your pre-built solutions
- If a prompt doesn't work well, use the alternative prompts in each DEMO_PROMPTS.md
- If technical issues arise, explain the concept using your refactored code

## Key Messages to Reinforce
- **Conversational**: "Notice how I'm having a conversation, not just asking for code"
- **Iterative**: "I refine my questions based on the responses"
- **Learning**: "I'm not just getting code, I'm understanding the reasoning"
- **Collaborative**: "It's about working together, not replacement"

## Tracking Patterns Across Runs
After each day, review your run folders to spot:
- **Consistency**: Does Copilot give similar quality responses?
- **Variations**: How do responses differ with same prompts?
- **Audience reactions**: Which scenarios resonate most?
- **Time management**: Which prompts take longer?
- **Best responses**: Save exemplary outputs for future reference

## Quick Commands
```bash
# Set up templates for run 2
./setup_run.sh 2

# View all runs for scenario 1
ls -la src/main/java/com/example/demo/scenario1/solutions/

# Find the best responses (search your notes)
grep -r "⭐⭐⭐⭐⭐" src/main/java/com/example/demo/*/solutions/
```

## Q&A Preparation
Common questions:
- Why chat over autocomplete?
- How has it changed your workflow?
- What types of problems is it best/worst for?
- Tips for effective prompting?
- Privacy/security concerns?
- Cost and availability?
