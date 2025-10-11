# Palindrome Partitioning

## Problem Statement

Given a string `s`, partition `s` such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of `s`.

## Examples

**Example 1:**
```
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
```

**Example 2:**
```
Input: s = "a"
Output: [["a"]]
```

## Approach

### Method 1: Backtracking with Palindrome Check (Recommended)
1. Use backtracking to generate all possible partitions
2. For each position, try all possible substrings
3. Check if substring is palindrome before adding
4. Use recursion to explore all possibilities

**Time Complexity:** O(2^n) - Exponential in worst case
**Space Complexity:** O(n) - Recursion stack depth

### Method 2: Dynamic Programming + Backtracking
1. Pre-compute palindrome table using DP
2. Use backtracking with pre-computed table
3. More efficient palindrome checking

**Time Complexity:** O(n^2 + 2^n) - DP + backtracking
**Space Complexity:** O(n^2) - Palindrome table

## Algorithm

```
1. Backtrack function:
   a. If start == s.length(): add current partition to result
   b. For each end position from start:
      - If substring is palindrome:
        - Add substring to partition
        - Recursively call with end + 1
        - Remove substring from partition (backtrack)
```

## Key Insights

- **Backtracking**: Explore all possible partitions
- **Palindrome Check**: Verify each substring is palindrome
- **Partition Building**: Build partition incrementally
- **State Restoration**: Remove substring after recursive call

## Alternative Approaches

1. **DP + Backtracking**: Pre-compute palindrome table
2. **Iterative**: Use iterative approach with stack
3. **Memoization**: Cache palindrome check results

## Edge Cases

- Single character: Return [[character]]
- Empty string: Return [[]]
- No palindromes: Return empty list
- All palindromes: Return all partitions

## Applications

- String processing
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Backtracking**: Most intuitive approach
- **Palindrome Table**: Pre-compute for efficiency
- **Early Termination**: Stop when no valid partitions
- **Memory Efficient**: O(n) space for recursion
