# Combination Sum

## Problem Statement

Given an array of distinct integers `candidates` and a target integer `target`, return a list of all unique combinations of `candidates` where the chosen numbers sum to `target`. You may return the combinations in any order.

The same number may be chosen from `candidates` an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

## Examples

**Example 1:**
```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
```

**Example 2:**
```
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
```

## Approach

### Method 1: Backtracking (Recommended)
1. Use backtracking to explore all possible combinations
2. For each candidate, try including it multiple times
3. Use recursion to explore all possibilities
4. Prune invalid paths early (when sum exceeds target)

**Time Complexity:** O(2^target) - Exponential in worst case
**Space Complexity:** O(target) - Recursion stack depth

### Method 2: Dynamic Programming
1. Use DP to build combinations bottom-up
2. For each target value, combine all possible ways
3. Use memoization to avoid recomputation

**Time Complexity:** O(target * candidates.length)
**Space Complexity:** O(target * candidates.length)

## Algorithm

```
1. Sort candidates array
2. Backtrack function:
   a. If target == 0: add current combination to result
   b. If target < 0: return (prune invalid path)
   c. For each candidate starting from current index:
      - Add candidate to combination
      - Recursively call with target - candidate
      - Remove candidate from combination (backtrack)
```

## Key Insights

- **Backtracking**: Explore all possible combinations
- **Unlimited Use**: Same number can be used multiple times
- **Pruning**: Stop when target becomes negative
- **Index Tracking**: Start from current index to avoid duplicates

## Alternative Approaches

1. **Dynamic Programming**: Use DP for optimization
2. **Iterative**: Use iterative approach with stack
3. **Memoization**: Cache results to avoid recomputation

## Edge Cases

- Empty candidates: Return empty list
- Target 0: Return [[]]
- No valid combinations: Return empty list
- Single candidate: Handle appropriately

## Applications

- Combinatorics
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Backtracking**: Most intuitive approach
- **Early Pruning**: Stop when target < 0
- **Sorting**: Sort candidates for better pruning
- **Index Tracking**: Avoid duplicate combinations
