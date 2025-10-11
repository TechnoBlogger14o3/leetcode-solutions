# Palindrome Partitioning

## Problem Statement

Given a string `s`, partition `s` such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of `s`.

## Examples

**Example 1:**
```
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
```

## Approach

### Method 1: Backtracking with DP Optimization (Recommended)
1. Use DP to precompute palindrome information
2. Use backtracking to generate all partitions
3. Combine DP optimization with backtracking
4. Most efficient approach

**Time Complexity:** O(2^n) - Exponential in worst case
**Space Complexity:** O(2^n) - Store all partitions

### Method 2: Pure Backtracking
1. Use backtracking to explore all possibilities
2. Check palindrome on-the-fly
3. Less efficient than DP + backtracking

**Time Complexity:** O(2^n) - Exponential in worst case
**Space Complexity:** O(2^n) - Store all partitions

## Algorithm

```
1. Use DP to precompute palindrome information
2. Use backtracking to generate partitions:
   a. For each possible palindrome ending at position i
   b. Recursively generate partitions for remaining string
   c. Combine current palindrome with all possible partitions
3. Return all generated partitions
```

## Key Insights

- **DP Optimization**: Precompute palindrome information
- **Backtracking**: Generate all possible partitions
- **Palindrome Check**: Use DP for O(1) palindrome check
- **Partition Generation**: Combine palindromes to form partitions

## Alternative Approaches

1. **Pure Backtracking**: Use only backtracking
2. **Memoization**: Use memoization to avoid recomputation
3. **Iterative**: Use iterative approach

## Edge Cases

- Empty string: Return empty list
- Single character: Return that character
- No palindromes: Return empty list
- All same characters: Return all possible partitions

## Applications

- Dynamic programming patterns
- String algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **DP Optimization**: Precompute palindrome information
- **Memoization**: Cache results
- **Early Termination**: Stop if no palindrome possible
- **Space Efficient**: Use only necessary space
