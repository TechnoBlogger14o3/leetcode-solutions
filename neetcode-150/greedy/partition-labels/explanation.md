# Partition Labels

## Problem Statement

You are given a string `s`. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be `s`.

Return a list of integers representing the size of these parts.

## Examples

**Example 1:**
```
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because the letters "a" and "b" appear in both parts.
```

## Approach

### Method 1: Greedy Algorithm (Recommended)
1. Find the last occurrence of each character
2. Use greedy approach to extend partition as far as possible
3. When we reach the end of current partition, add its length
4. Most efficient approach

**Time Complexity:** O(n) - Two passes
**Space Complexity:** O(1) - At most 26 characters

### Method 2: Two Pointers
1. Use two pointers to track partition boundaries
2. Extend partition until all characters are included
3. Less efficient than greedy approach

**Time Complexity:** O(n) - Two passes
**Space Complexity:** O(1) - At most 26 characters

## Algorithm

```
1. Find last occurrence of each character
2. Initialize start = 0, end = 0
3. For i from 0 to n-1:
   a. end = max(end, lastOccurrence[s[i]])
   b. If i == end:
      c. Add partition length to result
      d. start = i + 1
4. Return result
```

## Key Insights

- **Greedy Choice**: Extend partition as far as possible
- **Local Optimum**: Include all occurrences of current characters
- **Global Optimum**: Minimize number of partitions
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Two Pointers**: Use two pointers for boundaries
2. **Sliding Window**: Use sliding window technique
3. **Brute Force**: Try all possible partitions

## Edge Cases

- Empty string: Return empty list
- Single character: Return [1]
- All same characters: Return [n]
- No repeated characters: Return [1, 1, ..., 1]

## Applications

- Greedy algorithms
- String partitioning
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Greedy Algorithm**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Two Passes**: O(n) time complexity
- **No Extra Space**: Use only necessary space
