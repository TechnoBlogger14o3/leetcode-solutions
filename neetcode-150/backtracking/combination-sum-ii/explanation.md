# Combination Sum II

## Problem Statement

Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`.

Each number in `candidates` may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

## Examples

**Example 1:**
```
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
```

**Example 2:**
```
Input: candidates = [2,5,2,1,2], target = 5
Output: [[1,2,2],[5]]
```

## Approach

### Method 1: Backtracking with Duplicate Handling (Recommended)
1. Sort array to group duplicates together
2. Use backtracking to explore all possible combinations
3. Skip duplicates at same level to avoid duplicate combinations
4. Use each number only once

**Time Complexity:** O(2^n) - Exponential in worst case
**Space Complexity:** O(target) - Recursion stack depth

### Method 2: Dynamic Programming
1. Use DP to build combinations bottom-up
2. Handle duplicates by tracking previous combinations
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
      - Skip duplicates at same level
      - Add candidate to combination
      - Recursively call with target - candidate
      - Remove candidate from combination (backtrack)
```

## Key Insights

- **Sorting**: Group duplicates together
- **Skip Duplicates**: Skip same elements at same level
- **Single Use**: Each number used only once
- **Pruning**: Stop when target becomes negative

## Alternative Approaches

1. **Dynamic Programming**: Use DP for optimization
2. **Iterative**: Use iterative approach with stack
3. **Set**: Use Set to automatically handle duplicates

## Edge Cases

- Empty candidates: Return empty list
- Target 0: Return [[]]
- No valid combinations: Return empty list
- All duplicates: Handle appropriately

## Applications

- Combinatorics
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Backtracking**: Most intuitive approach
- **Early Pruning**: Stop when target < 0
- **Sorting**: Efficient duplicate handling
- **Skip Logic**: Avoid duplicate combinations
