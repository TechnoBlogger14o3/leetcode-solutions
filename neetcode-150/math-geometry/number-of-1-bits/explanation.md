# Number of 1 Bits

## Problem Statement

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

## Examples

**Example 1:**
```
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
```

## Approach

### Method 1: Bit Manipulation (Recommended)
1. Use n & (n-1) to remove rightmost 1 bit
2. Count iterations until n becomes 0
3. Most efficient approach

**Time Complexity:** O(k) - Where k is number of 1 bits
**Space Complexity:** O(1) - No extra space

### Method 2: Bit Shifting
1. Check each bit by shifting right
2. Count 1 bits
3. Less efficient than bit manipulation

**Time Complexity:** O(32) - Constant time
**Space Complexity:** O(1) - No extra space

## Algorithm

```
1. Initialize count = 0
2. While n != 0:
   a. n = n & (n-1)
   b. count++
3. Return count
```

## Key Insights

- **Bit Manipulation**: n & (n-1) removes rightmost 1 bit
- **Local Optimum**: Count 1 bits efficiently
- **Global Optimum**: Total number of 1 bits
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Bit Shifting**: Check each bit individually
2. **Built-in Function**: Use Integer.bitCount()
3. **Lookup Table**: Use precomputed table

## Edge Cases

- Zero: Return 0
- All 1s: Return 32
- Single 1: Return 1
- Large numbers: Handle efficiently

## Applications

- Bit manipulation
- Hamming weight
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Bit Manipulation**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Linear Time**: O(k) time complexity
- **No Extra Space**: Use only necessary space
