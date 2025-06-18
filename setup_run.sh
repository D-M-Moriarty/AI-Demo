#!/bin/bash

# Script to quickly set up templates for additional demo runs

if [ -z "$1" ]; then
    echo "Usage: ./setup_run.sh <run_number>"
    echo "Example: ./setup_run.sh 2"
    exit 1
fi

RUN_NUM=$1

echo "Setting up templates for Run $RUN_NUM..."

# Backup any existing generated README and reset to basic version
if [ -f "GENERATED_README.md" ]; then
    echo "Backing up generated README from previous run..."
    # Find the latest run folder that contains a DEMO_RESULTS.md to determine last run
    LAST_RUN=$(find src/main/java/com/example/demo/scenario2/solutions/ -name "DEMO_RESULTS.md" -path "*/run*/DEMO_RESULTS.md" | grep -o 'run[0-9]\+' | sed 's/run//' | sort -n | tail -1)
    if [ ! -z "$LAST_RUN" ]; then
        cp GENERATED_README.md "src/main/java/com/example/demo/scenario2/solutions/run$LAST_RUN/GENERATED_README.md"
        echo "  - Saved previous README to scenario2/solutions/run$LAST_RUN/"
    fi
fi

# Reset README to basic version for fresh demo
echo "Resetting README to basic version for clean demo..."
if [ -f "README_BASIC_TEMPLATE.md" ]; then
    cp README_BASIC_TEMPLATE.md README.md
    echo "  - README reset to basic template"
else
    git checkout HEAD -- README.md 2>/dev/null || echo "  - README already in basic state"
fi

echo ""

# Copy and update Scenario 1 template
cp src/main/java/com/example/demo/scenario1/solutions/run1/DEMO_RESULTS.md src/main/java/com/example/demo/scenario1/solutions/run$RUN_NUM/DEMO_RESULTS.md
sed -i "s/Demo Run 1/Demo Run $RUN_NUM/g" src/main/java/com/example/demo/scenario1/solutions/run$RUN_NUM/DEMO_RESULTS.md

# Copy and update Scenario 2 template  
cp src/main/java/com/example/demo/scenario2/solutions/run1/DEMO_RESULTS.md src/main/java/com/example/demo/scenario2/solutions/run$RUN_NUM/DEMO_RESULTS.md
sed -i "s/Demo Run 1/Demo Run $RUN_NUM/g" src/main/java/com/example/demo/scenario2/solutions/run$RUN_NUM/DEMO_RESULTS.md

# Copy and update Scenario 3 template
cp src/main/java/com/example/demo/scenario3/solutions/run1/DEMO_RESULTS.md src/main/java/com/example/demo/scenario3/solutions/run$RUN_NUM/DEMO_RESULTS.md
sed -i "s/Demo Run 1/Demo Run $RUN_NUM/g" src/main/java/com/example/demo/scenario3/solutions/run$RUN_NUM/DEMO_RESULTS.md

echo "Templates ready for Run $RUN_NUM!"
echo "Files created:"
echo "  - scenario1/solutions/run$RUN_NUM/DEMO_RESULTS.md"
echo "  - scenario2/solutions/run$RUN_NUM/DEMO_RESULTS.md" 
echo "  - scenario3/solutions/run$RUN_NUM/DEMO_RESULTS.md"
echo ""
echo "🎬 Demo environment ready:"
echo "  - README.md reset to basic version"
echo "  - Clean slate for Copilot README generation demo"
echo "  - Previous generated README saved (if any)"
