# Longest Repeating Character Replacement

## Problem Statement

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English letter. You can perform this operation at most `k` times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

## Examples

**Example 1:**
```
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
```

**Example 2:**
```
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
```

## Approach

### Method 1: Sliding Window (Recommended)
1. Use two pointers to define window
2. Track frequency of each character in window
3. Keep track of most frequent character
4. If window size - most frequent count > k, contract window

**Time Complexity:** O(n) - Single pass through the string
**Space Complexity:** O(1) - At most 26 characters

## Algorithm

```
1. Initialize left = 0, maxLength = 0, maxCount = 0
2. Use HashMap to track character frequencies
3. For each right pointer:
   a. Update character frequency
   b. Update maxCount = max(maxCount, frequency)
   c. If window size - maxCount > k:
      - Contract window from left
   d. Update maxLength
4. Return maxLength
```

## Key Insights

- **Sliding Window**: Expand right, contract left when needed
- **Character Frequency**: Track most frequent character
- **Replacement Logic**: Window size - max frequency <= k
- **Greedy Strategy**: Always try to maximize window size

## Alternative Approaches

1. **Brute Force**: Check all substrings - O(n²) time
2. **Fixed Window**: Try all possible window sizes
3. **Character-wise**: Process each character separately

## Edge Cases

- Empty string: Return 0
- k = 0: Return length of longest same-character substring
- All same characters: Return string length
- k >= string length: Return string length

## Applications

- String processing
- Data analysis
- Algorithm design patterns
- Interview preparation
- Text optimization

## Optimization Opportunities

- **Sliding Window**: Most efficient approach
- **Frequency Tracking**: O(1) updates
- **Single Pass**: Linear time complexity
- **Memory Efficient**: Constant space
