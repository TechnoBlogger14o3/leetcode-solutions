# Word Break

## Problem Statement

Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

## Examples

**Example 1:**
```
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP to store if substring can be segmented
2. dp[i] = true if s[0:i] can be segmented
3. Check all possible word endings at position i
4. Most efficient approach

**Time Complexity:** O(n² * m) - n string length, m word length
**Space Complexity:** O(n) - DP array

### Method 2: BFS
1. Use BFS to explore all possible segmentations
2. Each level represents a word boundary
3. Less efficient than DP

**Time Complexity:** O(n² * m) - n string length, m word length
**Space Complexity:** O(n) - Queue

## Algorithm

```
1. Initialize dp[0] = true
2. For i from 1 to n:
   a. For j from 0 to i-1:
      b. If dp[j] = true and s[j:i] in wordDict: dp[i] = true
3. Return dp[n]
```

## Key Insights

- **State Transition**: dp[i] = true if s[0:i] can be segmented
- **Word Dictionary**: Use HashSet for O(1) lookup
- **Substring Check**: Check all possible word endings
- **Space Optimization**: Use DP array

## Alternative Approaches

1. **BFS**: Use BFS for exploration
2. **Recursion**: Use recursive approach with memoization
3. **Trie**: Use Trie for word matching

## Edge Cases

- Empty string: Return true
- Empty wordDict: Return false
- Single character: Check if in wordDict
- No solution: Return false

## Applications

- Dynamic programming patterns
- String processing
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Dynamic Programming**: Most efficient approach
- **HashSet Lookup**: O(1) word lookup
- **Quadratic Time**: O(n² * m) time complexity
- **Space Efficient**: O(n) space complexity
