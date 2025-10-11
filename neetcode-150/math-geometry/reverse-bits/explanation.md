# Reverse Bits

## Problem Statement

Reverse bits of a given 32 bits unsigned integer.

## Examples

**Example 1:**
```
Input: n = 00000010100101000001111010011100
Output: 964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
```

## Approach

### Method 1: Bit Manipulation (Recommended)
1. Use bit shifting and OR operations
2. Build result bit by bit
3. Most efficient approach

**Time Complexity:** O(32) - Constant time
**Space Complexity:** O(1) - No extra space

### Method 2: String Conversion
1. Convert to binary string, reverse, convert back
2. Less efficient than bit manipulation

**Time Complexity:** O(32) - Constant time
**Space Complexity:** O(32) - String storage

## Algorithm

```
1. Initialize result = 0
2. For i from 0 to 31:
   a. result = (result << 1) | (n & 1)
   b. n = n >> 1
3. Return result
```

## Key Insights

- **Bit Manipulation**: Use bit shifting and OR operations
- **Local Optimum**: Reverse bits efficiently
- **Global Optimum**: Complete bit reversal
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **String Conversion**: Convert to string and reverse
2. **Lookup Table**: Use precomputed table
3. **Divide and Conquer**: Use divide and conquer approach

## Edge Cases

- Zero: Return 0
- All 1s: Return all 1s
- Single 1: Return appropriate value
- Large numbers: Handle efficiently

## Applications

- Bit manipulation
- Reverse operations
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Bit Manipulation**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Constant Time**: O(32) time complexity
- **No Extra Space**: Use only necessary space
