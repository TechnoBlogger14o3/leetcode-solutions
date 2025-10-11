# Minimum Window Substring

## Problem Statement

Given two strings `s` and `t` of lengths `m` and `n` respectively, return the **minimum window substring** of `s` such that every character in `t` (including duplicates) is included in the window. If there is no such window, return the empty string `""`.

The testcases will be generated such that the answer is **unique**.

A **substring** is a contiguous sequence of characters within the string.

## Examples

**Example 1:**
```
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
```

**Example 2:**
```
Input: s = "a", t = "a"
Output: "a"
```

## Approach

### Method 1: Sliding Window (Recommended)
1. Create frequency map for string t
2. Use two pointers to define window
3. Expand right pointer until all characters from t are included
4. Contract left pointer to minimize window
5. Keep track of minimum window

**Time Complexity:** O(m + n) - Where m is length of s, n is length of t
**Space Complexity:** O(m + n) - For frequency maps

## Algorithm

```
1. Create frequency map for t
2. Initialize left = 0, minStart = 0, minLen = infinity
3. Use counter to track characters needed
4. For each right pointer:
   a. If character in t: decrement counter
   b. While counter == 0 (all characters found):
      - Update minimum window if smaller
      - Move left pointer to contract window
5. Return minimum window substring
```

## Key Insights

- **Sliding Window**: Expand right, contract left when valid
- **Character Tracking**: Use frequency maps and counter
- **Valid Window**: All characters from t must be present
- **Minimization**: Contract window while maintaining validity

## Alternative Approaches

1. **Brute Force**: Check all substrings - O(m²) time
2. **Two Pass**: First pass to find all valid windows
3. **Optimized**: Skip unnecessary characters

## Edge Cases

- t longer than s: Return empty string
- No valid window: Return empty string
- Single character: Simple case
- All same characters: Handle duplicates

## Applications

- String processing
- Pattern matching
- Algorithm design patterns
- Interview preparation
- Text analysis

## Optimization Opportunities

- **Sliding Window**: Most efficient approach
- **Character Skipping**: Skip characters not in t
- **Early Exit**: Stop when minimum found
- **Memory Efficient**: Use arrays for ASCII characters
