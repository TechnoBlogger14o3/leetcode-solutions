# Power of Two

## Problem Statement

Given an integer `n`, return `true` if it is a power of two. Otherwise, return `false`.

An integer `n` is a power of two, if there exists an integer `x` such that `n == 2^x`.

## Examples

**Example 1:**
```
Input: n = 1
Output: true
Explanation: 2^0 = 1
```

## Approach

### Method 1: Bit Manipulation (Recommended)
1. Use bit manipulation: n & (n-1) == 0
2. Powers of two have only one bit set
3. Most efficient approach

**Time Complexity:** O(1) - Constant time
**Space Complexity:** O(1) - No extra space

### Method 2: Mathematical
1. Keep dividing by 2 until n becomes 1
2. Check if n becomes 1
3. Less efficient than bit manipulation

**Time Complexity:** O(log n) - Logarithmic time
**Space Complexity:** O(1) - No extra space

## Algorithm

```
1. Check if n > 0
2. Return n & (n-1) == 0
```

## Key Insights

- **Bit Manipulation**: Powers of two have only one bit set
- **Local Optimum**: Check bit pattern efficiently
- **Global Optimum**: Determine if number is power of two
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Mathematical**: Divide by 2 repeatedly
2. **Logarithm**: Use logarithm properties
3. **Brute Force**: Check all powers of two

## Edge Cases

- Zero: Return false
- One: Return true (2^0)
- Negative: Return false
- Large numbers: Handle efficiently

## Applications

- Bit manipulation
- Mathematical algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Bit Manipulation**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Constant Time**: O(1) time complexity
- **No Extra Space**: Use only necessary space
