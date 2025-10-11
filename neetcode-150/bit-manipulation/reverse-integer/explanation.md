# Reverse Integer

## Problem Statement

Given a signed 32-bit integer `x`, return `x` with its digits reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, then return `0`.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

## Examples

**Example 1:**
```
Input: x = 123
Output: 321
```

## Approach

### Method 1: Mathematical Approach (Recommended)
1. Extract digits using modulo and division
2. Build result digit by digit
3. Check for overflow before adding
4. Most efficient approach

**Time Complexity:** O(log n) - Number of digits
**Space Complexity:** O(1) - No extra space

### Method 2: String Conversion
1. Convert to string, reverse, convert back
2. Less efficient than mathematical approach

**Time Complexity:** O(log n) - String operations
**Space Complexity:** O(log n) - String storage

## Algorithm

```
1. Initialize result = 0
2. While x != 0:
   a. Check for overflow before adding
   b. result = result * 10 + x % 10
   c. x = x / 10
3. Return result
```

## Key Insights

- **Overflow Check**: Check before adding to prevent overflow
- **Local Optimum**: Extract digits efficiently
- **Global Optimum**: Reverse number without overflow
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **String Conversion**: Convert to string and reverse
2. **Stack**: Use stack for digit reversal
3. **Recursive**: Use recursive approach

## Edge Cases

- Zero: Return 0
- Single digit: Return that digit
- Negative numbers: Handle sign appropriately
- Overflow: Return 0

## Applications

- Number manipulation
- Overflow handling
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Mathematical Approach**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Logarithmic Time**: O(log n) time complexity
- **No Extra Space**: Use only necessary space
