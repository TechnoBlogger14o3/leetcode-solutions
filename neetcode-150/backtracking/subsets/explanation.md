# Subsets

## Problem Statement

Given an integer array `nums` of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

## Examples

**Example 1:**
```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

**Example 2:**
```
Input: nums = [0]
Output: [[],[0]]
```

## Approach

### Method 1: Backtracking (Recommended)
1. Use backtracking to generate all possible subsets
2. For each element, choose to include or exclude it
3. Use recursion to explore all possibilities
4. Add current subset to result when base case is reached

**Time Complexity:** O(2^n) - 2^n possible subsets
**Space Complexity:** O(n) - Recursion stack depth

### Method 2: Iterative
1. Start with empty subset
2. For each element, add it to all existing subsets
3. Create new subsets by including current element

**Time Complexity:** O(2^n) - 2^n possible subsets
**Space Complexity:** O(2^n) - Store all subsets

## Algorithm

```
1. Initialize result list and current subset
2. Backtrack function:
   a. Add current subset to result
   b. For each remaining element:
      - Add element to subset
      - Recursively call backtrack
      - Remove element from subset (backtrack)
3. Return result list
```

## Key Insights

- **Backtracking**: Explore all possible combinations
- **Include/Exclude**: For each element, choose to include or exclude
- **Base Case**: Add current subset when all elements processed
- **State Restoration**: Remove element after recursive call

## Alternative Approaches

1. **Iterative**: Build subsets iteratively
2. **Bit Manipulation**: Use bit masks to represent subsets
3. **Recursive**: Use recursion without backtracking

## Edge Cases

- Empty array: Return [[]]
- Single element: Return [[], [element]]
- Two elements: Return [[], [a], [b], [a,b]]
- All elements: Return power set

## Applications

- Combinatorics
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Backtracking**: Most intuitive approach
- **Early Termination**: Stop when no more elements
- **Memory Efficient**: O(n) space for recursion
- **Time Efficient**: O(2^n) optimal time complexity
