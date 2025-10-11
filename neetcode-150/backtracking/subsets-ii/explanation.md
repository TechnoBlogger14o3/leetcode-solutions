# Subsets II

## Problem Statement

Given an integer array `nums` that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

## Examples

**Example 1:**
```
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
```

**Example 2:**
```
Input: nums = [0]
Output: [[],[0]]
```

## Approach

### Method 1: Backtracking with Duplicate Handling (Recommended)
1. Sort array to group duplicates together
2. Use backtracking to generate all possible subsets
3. Skip duplicates at same level to avoid duplicate subsets
4. Use recursion to explore all possibilities

**Time Complexity:** O(2^n) - 2^n possible subsets
**Space Complexity:** O(n) - Recursion stack depth

### Method 2: Iterative with Duplicate Handling
1. Sort array to group duplicates together
2. Build subsets iteratively
3. Handle duplicates by tracking previous subset count

**Time Complexity:** O(2^n) - 2^n possible subsets
**Space Complexity:** O(2^n) - Store all subsets

## Algorithm

```
1. Sort nums array
2. Backtrack function:
   a. Add current subset to result
   b. For each remaining element:
      - Skip duplicates at same level
      - Add element to subset
      - Recursively call backtrack
      - Remove element from subset (backtrack)
```

## Key Insights

- **Sorting**: Group duplicates together
- **Skip Duplicates**: Skip same elements at same level
- **Backtracking**: Explore all possible combinations
- **Duplicate Handling**: Avoid duplicate subsets

## Alternative Approaches

1. **Iterative**: Build subsets iteratively with duplicate handling
2. **Set**: Use Set to automatically handle duplicates
3. **Bit Manipulation**: Use bit masks with duplicate handling

## Edge Cases

- Empty array: Return [[]]
- Single element: Return [[], [element]]
- All duplicates: Return unique subsets
- No duplicates: Same as regular subsets

## Applications

- Combinatorics
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Backtracking**: Most intuitive approach
- **Sorting**: Efficient duplicate handling
- **Skip Logic**: Avoid duplicate subsets
- **Memory Efficient**: O(n) space for recursion
