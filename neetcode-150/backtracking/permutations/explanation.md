# Permutations

## Problem Statement

Given an array `nums` of distinct integers, return all the possible permutations. You can return the answer in any order.

## Examples

**Example 1:**
```
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

**Example 2:**
```
Input: nums = [0,1]
Output: [[0,1],[1,0]]
```

## Approach

### Method 1: Backtracking (Recommended)
1. Use backtracking to generate all possible permutations
2. For each position, try all remaining elements
3. Use recursion to explore all possibilities
4. Mark used elements to avoid duplicates

**Time Complexity:** O(n!) - n! possible permutations
**Space Complexity:** O(n) - Recursion stack depth

### Method 2: Iterative
1. Start with empty permutation
2. For each position, add all possible elements
3. Use queue to maintain current permutations

**Time Complexity:** O(n!) - n! possible permutations
**Space Complexity:** O(n!) - Store all permutations

## Algorithm

```
1. Initialize result list and current permutation
2. Backtrack function:
   a. If permutation is complete: add to result
   b. For each unused element:
      - Add element to permutation
      - Mark element as used
      - Recursively call backtrack
      - Unmark element and remove from permutation
```

## Key Insights

- **Backtracking**: Explore all possible arrangements
- **Used Tracking**: Mark elements to avoid duplicates
- **Position-based**: Fill positions one by one
- **State Restoration**: Unmark elements after recursive call

## Alternative Approaches

1. **Iterative**: Build permutations iteratively
2. **Heap's Algorithm**: Use Heap's algorithm for generation
3. **Next Permutation**: Generate next permutation in lexicographic order

## Edge Cases

- Single element: Return [[element]]
- Two elements: Return [[a,b], [b,a]]
- Empty array: Return [[]]
- All elements: Return all permutations

## Applications

- Combinatorics
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Backtracking**: Most intuitive approach
- **Used Array**: Efficient tracking of used elements
- **Early Termination**: Stop when permutation complete
- **Memory Efficient**: O(n) space for recursion
