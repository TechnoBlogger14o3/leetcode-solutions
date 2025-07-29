#!/bin/bash

# Script to create a new LeetCode problem folder with proper structure
# Usage: ./create_problem.sh <date> <problem_id> <title> <difficulty>

if [ $# -ne 4 ]; then
    echo "Usage: $0 <date> <problem_id> <title> <difficulty>"
    echo "Example: $0 2025-01-27 0001 TwoSum Easy"
    exit 1
fi

DATE=$1
PROBLEM_ID=$2
TITLE=$3
DIFFICULTY=$4

# Create folder name
FOLDER_NAME="${DATE}-${PROBLEM_ID}-${TITLE}"
FOLDER_PATH="${DIFFICULTY}/${FOLDER_NAME}"

# Create directory
mkdir -p "$FOLDER_PATH"

# Create Java solution file
cat > "$FOLDER_PATH/solution.java" << EOF
// Solution for LeetCode Problem #${PROBLEM_ID}: ${TITLE}
// Date: ${DATE}
// Difficulty: ${DIFFICULTY}
// Language: Java

class Solution {
    // TODO: Implement your solution here
    
}
EOF

# Create JavaScript solution file
cat > "$FOLDER_PATH/solution.js" << EOF
// Solution for LeetCode Problem #${PROBLEM_ID}: ${TITLE}
// Date: ${DATE}
// Difficulty: ${DIFFICULTY}
// Language: JavaScript

/**
 * TODO: Add parameter types and return type
 */
var solution = function() {
    // TODO: Implement your solution here
    
};
EOF

# Create explanation file
cat > "$FOLDER_PATH/explanation.md" << EOF
# ${TITLE} - Problem #${PROBLEM_ID}

## Problem Statement
<!-- Add problem statement here -->

## Examples
<!-- Add examples here -->

## Approach
<!-- Describe your approach here -->

## Complexity Analysis
- **Time Complexity**: 
- **Space Complexity**: 

## Key Insights
<!-- Add key insights here -->

## Alternative Approaches
<!-- List alternative approaches if any -->

## Solutions in Different Languages

### Java
\`\`\`java
// See solution.java
\`\`\`

### JavaScript
\`\`\`javascript
// See solution.js
\`\`\`
EOF

echo "✅ Created problem folder: $FOLDER_PATH"
echo "📁 Files created:"
echo "   - $FOLDER_PATH/solution.java"
echo "   - $FOLDER_PATH/solution.js"
echo "   - $FOLDER_PATH/explanation.md"
echo ""
echo "📝 Don't forget to update README.md with the new problem entry!"
echo "🌍 Solutions are now available in Java and JavaScript!"