# GitHub Copilot Chat Demo Script

**Total Time: 10 minutes | Audience: [Fill in before demo]**

## Pre-Demo Setup (30 seconds)
1. **Open VS Code** with this project
2. **Run setup script**: `./setup_run.sh [run_number]` 
   - This resets README to basic version
   - Creates fresh result templates
3. **Have ready**:
   - `DEMO_SCRIPT.md` (this file) open for reference
   - Terminal ready
   - Copilot Chat panel open

---

## Introduction (1.5 minutes)

### Opening (30 seconds)
> "I'm going to show you GitHub Copilot Chat in action with three real-world scenarios developers face daily. This isn't scripted - I'm having actual conversations with Copilot to solve problems."

### Context Setting (30 seconds)
> "We have a Java project with three scenarios: legacy code refactoring, project documentation, and debugging. Each demonstrates different Copilot capabilities."

**Action**: Show project structure briefly
```bash
tree src/ -I target
```

### Team Collaboration Feature (30 seconds)
> "First, let me show you something new - prompt files. These let teams standardize and share their Copilot workflows."

**Action**: Show `.github/prompts/` folder and explain
> "Instead of everyone typing different prompts, we can create reusable prompt files that capture our team's best practices and ensure consistent results."

**Demo**: Run a prompt file (Copy-paste exactly):
```
/refactor-legacy-code
```

**While Copilot responds**:
- "Notice how this uses our team's specific refactoring guidelines"
- "These prompt files can be version controlled and shared across the team"
- "It references our coding standards from the copilot-instructions.md file"

---

## Scenario 1: Legacy Code Refactoring (3 minutes)

### Setup (15 seconds)
**Action**: Open `src/main/java/com/example/demo/scenario1/DataProcessor.java`

> "Here's a classic 'God class' - it violates SOLID principles and is hard to maintain."

### Demo Conversation (2 minutes)

**Copilot Prompt 1** (Copy-paste exactly):
```
This class violates SOLID principles. How would you refactor it using design patterns?
```

**While Copilot responds** (talking points):
- "Notice how it understands the code structure"
- "It's identifying specific SOLID violations"
- "This is like having a senior architect review my code"

**Copilot Prompt 2** (Follow-up):
```
I'm thinking factory + strategy pattern. Walk me through that approach with concrete examples.
```

**While Copilot responds**:
- "It's giving me a complete implementation plan"
- "See how it connects the pattern to my specific code"

### Proof of Concept (30 seconds)
**Action**: Run the before/after comparison
```bash
mvn exec:java -Dexec.mainClass="com.example.demo.DemoRunner"
```

**While it runs**:
> "Let me prove both versions work identically. Same input, same output - but the refactored version is much cleaner."

### Wrap-up (15 seconds)
**Action**: Show `src/main/java/com/example/demo/scenario1/refactored/` folder

> "I've implemented this approach - you can see the clean factory and strategy patterns. The original 150-line class became several focused 10-20 line classes."

---

## Scenario 2: Project README Generation (2 minutes)

### Setup (15 seconds)
**Action**: Show current basic `README.md`

> "This README is pretty basic. Let's use our team's standardized prompt to generate comprehensive documentation."

### Demo Conversation (1 minute)

**Copilot Prompt** (Use prompt file):
```
/generate-project-readme
```

**While Copilot responds**:
- "Notice how the prompt file gives Copilot specific guidelines about structure and content"
- "This ensures consistent documentation across all our projects"
- "Same team standards, different projects - the prompt file adapts"

**Optional Follow-up** (if time allows):
```
Now focus on the architecture section and include more technical details for developers.
```

### Wrap-up (45 seconds)
**Action**: Show `GENERATED_README.md` if available

> "This demonstrates two powerful features: AI-generated documentation AND team standardization through prompt files. Every developer on our team gets the same quality output."

---

## Scenario 3: Bug Detection & Debugging (2 minutes)

### Setup (30 seconds)
**Action**: Open `src/main/java/com/example/demo/scenario3/BuggyCache.java`

> "This cache implementation has some nasty bugs. Let's use our team's debugging prompt to analyze it systematically."

**Action**: Run the failing test to show the problem
```bash
mvn test -Dtest="BuggyCacheTest#testConcurrentAccess"
```

### Demo Conversation (1 minute)

**Copilot Prompt** (Use prompt file):
```
/debug-code-issues
```

**While Copilot responds**:
- "The prompt file ensures we get a comprehensive analysis covering all critical areas"
- "Notice how it prioritizes issues by severity - just like our code review checklist"
- "This standardized approach helps catch issues consistently across our team"

**Optional Follow-up** (if time allows):
```
Focus specifically on the threading issues and race conditions.
```

### Wrap-up (30 seconds)
> "The prompt file captured our team's debugging methodology. Every developer gets the same thorough analysis, whether they're junior or senior."

---

## Closing & Q&A (1.5 minutes)

### Summary (45 seconds)
> "In 8 minutes, we've seen Copilot:
> - Refactor legacy code with design patterns
> - Generate professional documentation from code analysis  
> - Debug complex threading issues
> 
> But more importantly, we've seen how **prompt files and custom instructions** enable teams to:
> - Standardize AI workflows across developers
> - Capture and share institutional knowledge
> - Ensure consistent quality in AI-generated outputs
> - Version control their AI 'playbooks'"

### Team Benefits (45 seconds)
> "This isn't just about individual productivity - it's about **team scalability**:
> - Junior developers get senior-level guidance through standardized prompts
> - Code reviews become more consistent and thorough
> - Documentation quality improves across all projects
> - Teams can evolve their AI practices together"

### Transition to Q&A (30 seconds)
> "Questions about what you've seen? I'm happy to dive deeper into any of these scenarios or the team collaboration features."

---

## Post-Demo Actions
1. **Save Copilot responses**: Copy outputs to `scenario*/solutions/run[X]/DEMO_RESULTS.md`
2. **Save generated README**: If Copilot generated a README, save it as `GENERATED_README.md`
3. **Rate quality**: Add star ratings and notes to results files
4. **Quick debrief**: What worked well? Any surprises?
5. **For next run**: Use `./setup_run.sh [next_number]` to reset environment

---

## Emergency Backup Plans

### If Copilot gives unexpected response:
- "That's interesting - let me rephrase that..."
- Use alternative prompts from `DEMO_PROMPTS.md` files
- Compare with pre-built solutions in `solutions/` folders

### If technical issues:
- Pre-built examples in each `scenario*/refactored/` or `solutions/` folder
- Can walk through the solutions manually
- "Let me show you what Copilot typically generates..."

### If running over time:
- Skip follow-up prompts, go straight to wrap-up
- "In the interest of time, let me show you the typical output..."

---

## Audience-Specific Talking Points

### For Developers:
- Focus on code quality and architecture
- Emphasize time savings and learning opportunities
- Mention testing and maintainability benefits

### For Managers:
- Emphasize productivity gains and quality improvements
- Focus on reduced time-to-market
- Mention knowledge sharing and onboarding benefits

### For Architects:
- Focus on design patterns and best practices
- Emphasize consistency across teams
- Mention technical debt reduction

---

**Remember**: This is a conversation with AI, not a script. Be natural, react to what Copilot says, and let the audience see the genuine interaction!
