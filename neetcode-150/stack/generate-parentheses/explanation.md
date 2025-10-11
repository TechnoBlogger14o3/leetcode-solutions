# Generate Parentheses

## Problem Statement

Given `n` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

## Examples

**Example 1:**
```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```

**Example 2:**
```
Input: n = 1
Output: ["()"]
```

## Approach

### Method 1: Backtracking (Recommended)
1. Use recursion to build valid combinations
2. Track open and close counts
3. Add '(' if open < n
4. Add ')' if close < open
5. Base case: both counts equal n

**Time Complexity:** O(4^n / √n) - Catalan number
**Space Complexity:** O(n) - Recursion depth

### Method 2: Iterative
1. Build combinations iteratively
2. More complex but avoids recursion

**Time Complexity:** O(4^n / √n)
**Space Complexity:** O(4^n / √n) - Store all combinations

## Algorithm

```
Backtrack(open, close, current):
1. If open == n and close == n: add to result
2. If open < n: add '(' and recurse
3. If close < open: add ')' and recurse
4. Return when both conditions met
```

## Key Insights

- **Backtracking**: Explore all valid combinations
- **Constraint Tracking**: Track open and close counts
- **Valid Formation**: Only add ')' when close < open
- **Catalan Numbers**: Number of valid combinations

## Alternative Approaches

1. **Iterative**: Build combinations without recursion
2. **Dynamic Programming**: Use DP to build solutions
3. **Mathematical**: Use Catalan number formula

## Edge Cases

- n = 0: Return empty list
- n = 1: Return ["()"]
- Large n: Handle exponential growth
- Memory constraints: Consider iterative approach

## Applications

- Combinatorics
- Algorithm design patterns
- Interview preparation
- Code generation
- Parsing algorithms

## Optimization Opportunities

- **Backtracking**: Most efficient approach
- **Early Pruning**: Stop invalid branches early
- **Memory Efficient**: Generate on demand
- **Mathematical**: Use Catalan number properties
