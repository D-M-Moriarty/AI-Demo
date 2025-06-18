# Prompt Files Demo Guide

## Quick Setup for Demo

### Enable Prompt Files in VS Code
Add to workspace settings (`.vscode/settings.json`):
```json
{
  "chat.promptFiles": true,
  "github.copilot.chat.codeGeneration.useInstructionFiles": true
}
```

### Available Prompt Files
Located in `.github/prompts/`:

| Prompt File | Command | Purpose |
|------------|---------|---------|
| `refactor-legacy-code.prompt.md` | `/refactor-legacy-code` | Analyze code for SOLID violations and suggest design patterns |
| `generate-project-readme.prompt.md` | `/generate-project-readme` | Create comprehensive project documentation |
| `debug-code-issues.prompt.md` | `/debug-code-issues` | Systematic code analysis for bugs and issues |
| `generate-team-standards.prompt.md` | `/generate-team-standards` | Create team coding standards documentation |

## Demo Usage

### During Scenario 1 (Refactoring):
```
/refactor-legacy-code
```
**Show**: How it references team standards and provides structured analysis

### During Scenario 2 (Documentation):
```
/generate-project-readme
```
**Show**: Consistent documentation structure across projects

### During Scenario 3 (Debugging):
```
/debug-code-issues
```
**Show**: Systematic debugging approach with priority levels

## Key Demo Points

### Team Collaboration Benefits:
- ✅ **Consistent Output**: All team members get same quality results
- ✅ **Knowledge Sharing**: Best practices captured in reusable prompts
- ✅ **Onboarding**: Junior developers get senior-level guidance
- ✅ **Version Control**: Prompt files evolve with team practices

### Enterprise Features:
- ✅ **Standardization**: Unified approach to common tasks
- ✅ **Quality Control**: Prompts encode team's quality standards
- ✅ **Scalability**: Works across multiple projects and teams
- ✅ **Governance**: Centralized control of AI interactions

## Talking Points for Different Audiences

### For Developers:
- "Stop retyping the same prompts - save them as team templates"
- "Get consistent code review quality every time"
- "Share your best prompts with the team"

### For Team Leads:
- "Standardize how your team uses AI across projects"
- "Capture institutional knowledge in reusable formats"
- "Ensure consistent quality in AI-generated outputs"

### For Managers:
- "Scale senior developer expertise across the entire team"
- "Reduce onboarding time with standardized AI workflows"
- "Improve code quality consistency across projects"

## Fallback Options

If prompt files don't work:
1. Copy content from `.prompt.md` files directly into chat
2. Use regular prompts but mention "this is what we'd put in a prompt file"
3. Show the files as documentation of team standards

## Quick File Overview Demo

**Action**: Show file structure
```bash
tree .github/
```

**Expected Output**:
```
.github/
├── copilot-instructions.md
└── prompts/
    ├── debug-code-issues.prompt.md
    ├── generate-project-readme.prompt.md
    ├── generate-team-standards.prompt.md
    └── refactor-legacy-code.prompt.md
```

**Talking Point**: "These files travel with the repository - instant team standardization for any new developer."
