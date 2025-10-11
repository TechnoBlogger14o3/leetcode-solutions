# Longest Palindromic Substring

## Problem Statement

Given a string `s`, return the longest palindromic substring in `s`.

## Examples

**Example 1:**
```
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
```

## Approach

### Method 1: Expand Around Centers (Recommended)
1. For each character, expand around it as center
2. Handle both odd and even length palindromes
3. Keep track of longest palindrome found
4. Most efficient approach

**Time Complexity:** O(n²) - n centers, each expansion O(n)
**Space Complexity:** O(1) - Two variables

### Method 2: Dynamic Programming
1. Use DP table to store palindrome information
2. dp[i][j] = true if s[i:j] is palindrome
3. Fill DP table and track longest palindrome
4. Less efficient than expand around centers

**Time Complexity:** O(n²) - Fill DP table
**Space Complexity:** O(n²) - DP table

## Algorithm

```
1. For each character i:
   a. Expand around i as center (odd length)
   b. Expand around i and i+1 as center (even length)
2. Keep track of longest palindrome
3. Return longest palindrome
```

## Key Insights

- **Expand Around Centers**: Check all possible centers
- **Odd and Even**: Handle both odd and even length palindromes
- **Longest Tracking**: Keep track of longest palindrome found
- **Space Optimization**: O(1) space complexity

## Alternative Approaches

1. **Dynamic Programming**: Use DP table
2. **Manacher's Algorithm**: O(n) time complexity
3. **Brute Force**: Check all substrings

## Edge Cases

- Empty string: Return empty string
- Single character: Return that character
- All same characters: Return entire string
- No palindrome: Return first character

## Applications

- String algorithms
- Dynamic programming patterns
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Expand Around Centers**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Quadratic Time**: O(n²) time complexity
- **No Extra Space**: Use only two variables
