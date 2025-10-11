# Valid Parenthesis String

## Problem Statement

Given a string `s` containing only three types of characters: `'('`, `')'` and `'*'`, return `true` if `s` is valid.

The following rules define a valid string:

- Any left parenthesis `'('` must have a corresponding right parenthesis `')'`.
- Any right parenthesis `')'` must have a corresponding left parenthesis `'('`.
- Left parenthesis `'('` must go before the corresponding right parenthesis `')'`.
- `'*'` could be treated as a single right parenthesis `')'`, a single left parenthesis `'('`, or an empty string.

## Examples

**Example 1:**
```
Input: s = "()"
Output: true
```

## Approach

### Method 1: Greedy Algorithm (Recommended)
1. Track minimum and maximum possible open parentheses
2. Use greedy approach to handle wildcards
3. If min becomes negative, reset to 0
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - Two variables

### Method 2: Dynamic Programming
1. Use DP to track all possible states
2. Less efficient than greedy approach
3. More complex implementation

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(n) - DP array

## Algorithm

```
1. Initialize minOpen = 0, maxOpen = 0
2. For each character in s:
   a. If '(': minOpen++, maxOpen++
   b. If ')': minOpen--, maxOpen--
   c. If '*': minOpen--, maxOpen++
   d. If maxOpen < 0: return false
   e. If minOpen < 0: minOpen = 0
3. Return minOpen == 0
```

## Key Insights

- **Greedy Choice**: Handle wildcards optimally
- **Local Optimum**: Track possible open parentheses
- **Global Optimum**: Can form valid parentheses
- **Space Optimization**: Use only two variables

## Alternative Approaches

1. **Dynamic Programming**: Use DP array
2. **Backtracking**: Use backtracking to explore all possibilities
3. **Stack**: Use stack to track parentheses

## Edge Cases

- Empty string: Return true
- Single character: Handle appropriately
- All wildcards: Return true
- No wildcards: Use standard parentheses validation

## Applications

- Greedy algorithms
- String validation
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Greedy Algorithm**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **No Extra Space**: Use only two variables
