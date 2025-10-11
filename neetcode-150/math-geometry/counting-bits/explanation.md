# Counting Bits

## Problem Statement

Given an integer `n`, return an array `ans` of length `n + 1` such that for each `i` (0 <= i <= n), `ans[i]` is the number of 1's in the binary representation of `i`.

## Examples

**Example 1:**
```
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP: ans[i] = ans[i >> 1] + (i & 1)
2. Build solution bottom-up
3. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - Excluding output array

### Method 2: Bit Manipulation
1. Use n & (n-1) for each number
2. Less efficient than DP approach

**Time Complexity:** O(n * k) - Where k is average number of 1 bits
**Space Complexity:** O(1) - Excluding output array

## Algorithm

```
1. Initialize ans[0] = 0
2. For i from 1 to n:
   a. ans[i] = ans[i >> 1] + (i & 1)
3. Return ans
```

## Key Insights

- **Dynamic Programming**: Use previous results
- **Local Optimum**: Calculate bits efficiently
- **Global Optimum**: All bit counts computed
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Bit Manipulation**: Use n & (n-1) for each number
2. **Built-in Function**: Use Integer.bitCount()
3. **Brute Force**: Count bits for each number

## Edge Cases

- Zero: Return [0]
- One: Return [0, 1]
- Small numbers: Handle efficiently
- Large numbers: Handle efficiently

## Applications

- Bit manipulation
- Dynamic programming
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Dynamic Programming**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Linear Time**: O(n) time complexity
- **No Extra Space**: Use only necessary space
