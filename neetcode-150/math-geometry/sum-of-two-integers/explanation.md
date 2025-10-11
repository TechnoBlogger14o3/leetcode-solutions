# Sum of Two Integers

## Problem Statement

Given two integers `a` and `b`, return the sum of the two integers without using the operators `+` and `-`.

## Examples

**Example 1:**
```
Input: a = 1, b = 2
Output: 3
```

## Approach

### Method 1: Bit Manipulation (Recommended)
1. Use XOR for sum without carry
2. Use AND and left shift for carry
3. Repeat until no carry
4. Most efficient approach

**Time Complexity:** O(32) - Constant time
**Space Complexity:** O(1) - No extra space

### Method 2: Iterative Addition
1. Use bit manipulation iteratively
2. Less efficient than recursive approach

**Time Complexity:** O(32) - Constant time
**Space Complexity:** O(1) - No extra space

## Algorithm

```
1. While b != 0:
   a. sum = a ^ b (sum without carry)
   b. carry = (a & b) << 1 (carry)
   c. a = sum, b = carry
2. Return a
```

## Key Insights

- **Bit Manipulation**: Use XOR and AND operations
- **Local Optimum**: Calculate sum and carry efficiently
- **Global Optimum**: Complete addition without + and -
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Iterative**: Use iterative approach
2. **Recursive**: Use recursive approach
3. **Lookup Table**: Use precomputed table

## Edge Cases

- Zero: Handle appropriately
- Negative numbers: Handle two's complement
- Large numbers: Handle efficiently
- Same numbers: Handle appropriately

## Applications

- Bit manipulation
- Arithmetic operations
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Bit Manipulation**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Constant Time**: O(32) time complexity
- **No Extra Space**: Use only necessary space
