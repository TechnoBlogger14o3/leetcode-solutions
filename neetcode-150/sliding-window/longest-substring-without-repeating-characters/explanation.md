# Longest Substring Without Repeating Characters

## Problem Statement

Given a string `s`, find the length of the longest substring without repeating characters.

## Examples

**Example 1:**
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

**Example 2:**
```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

**Example 3:**
```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

## Approach

### Method 1: Sliding Window with HashMap (Recommended)
1. Use two pointers (left, right) to define window
2. Use HashMap to track character frequencies
3. Expand right pointer, contract left when duplicate found
4. Keep track of maximum window size

**Time Complexity:** O(n) - Each character visited at most twice
**Space Complexity:** O(min(m,n)) - Where m is charset size

### Method 2: Sliding Window with Set
1. Use Set to track characters in current window
2. Similar two-pointer approach
3. Remove characters when contracting window

**Time Complexity:** O(n) - Each character visited at most twice
**Space Complexity:** O(min(m,n)) - For Set

## Algorithm

```
1. Initialize left = 0, maxLength = 0
2. Use HashMap to track character frequencies
3. For each right pointer:
   a. Add character to window
   b. While window has duplicates:
      - Remove character at left
      - Move left pointer
   c. Update maxLength = max(maxLength, right - left + 1)
4. Return maxLength
```

## Key Insights

- **Sliding Window**: Expand right, contract left when needed
- **Character Tracking**: Use HashMap/Set for O(1) lookup
- **Two Pointers**: Efficient way to maintain valid window
- **Duplicate Detection**: Contract window until no duplicates

## Alternative Approaches

1. **Brute Force**: Check all substrings - O(n³) time
2. **Set-based**: Use Set instead of HashMap
3. **Array-based**: Use array for ASCII characters

## Edge Cases

- Empty string: Return 0
- Single character: Return 1
- All same characters: Return 1
- No duplicates: Return string length
- Mixed case: Handle case sensitivity

## Applications

- String processing
- Data validation
- Algorithm design patterns
- Interview preparation
- Text analysis

## Optimization Opportunities

- **Sliding Window**: Most efficient approach
- **HashMap Lookup**: O(1) average time
- **Single Pass**: Each character visited at most twice
- **Memory Efficient**: Only store necessary characters
