# Power of Four

## Problem Description
Given an integer `n`, return `true` if it is a power of four. Otherwise, return `false`.

An integer `n` is a power of four if there exists an integer `x` such that `n == 4^x`.

## Approach

### Method 1: Iterative Division
The most straightforward approach is to keep dividing the number by 4 until we can't divide evenly anymore.

**Algorithm:**
1. Handle edge cases: return `false` for non-positive numbers, return `true` for 1
2. While the number is divisible by 4, keep dividing by 4
3. If we end up with 1, it's a power of 4; otherwise, it's not

**Time Complexity:** O(log₄ n) - we divide by 4 at most log₄ n times
**Space Complexity:** O(1) - constant extra space

### Method 2: Bit Manipulation (Optimal)
A more efficient approach using bit manipulation properties of powers of 4.

**Key Insight:** A number is a power of 4 if and only if:
1. It's positive
2. It's a power of 2 (only one bit set)
3. The single bit is in an even position (0, 2, 4, 6, ...)

**Algorithm:**
1. Check if n > 0
2. Check if n is a power of 2: `(n & (n - 1)) == 0`
3. Check if the bit is in even position: `(n & 0xAAAAAAAA) == 0`

**Time Complexity:** O(1) - constant time bit operations
**Space Complexity:** O(1) - constant extra space

### Method 3: Mathematical Properties
Uses the fact that the largest power of 4 that fits in int is 4¹⁵ = 1073741824.

**Algorithm:**
1. Check if n > 0
2. Check if n is a power of 2
3. Check if 1073741824 % n == 0

**Time Complexity:** O(1) - constant time operations
**Space Complexity:** O(1) - constant extra space

## Key Insights
1. **Powers of 4**: 1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216, 67108864, 268435456, 1073741824
2. **Bit Pattern**: Powers of 4 have exactly one bit set, and that bit is in an even position
3. **Relationship to Powers of 2**: All powers of 4 are also powers of 2, but not all powers of 2 are powers of 4
4. **Even Bit Positions**: The bit positions for powers of 4 are 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30

## Examples
- **n = 16**: 16 ÷ 4 = 4, 4 ÷ 4 = 1 → `true` (4²)
- **n = 0**: → `false` (not positive)
- **n = 8**: 8 ÷ 4 = 2, 2 is not divisible by 4 → `false` (power of 2 but not 4)
- **n = 64**: 64 ÷ 4 = 16, 16 ÷ 4 = 4, 4 ÷ 4 = 1 → `true` (4³)

## Bit Manipulation Details
- **0xAAAAAAAA**: This is a mask where all even bits (0, 2, 4, 6, ...) are set to 1
- **n & (n - 1)**: This operation clears the least significant bit. If the result is 0, n has exactly one bit set
- **Even Position Check**: Powers of 4 have their single bit in even positions, so `(n & 0xAAAAAAAA)` should be 0

## Edge Cases
1. **Negative numbers and 0**: Return `false`
2. **1**: Return `true` (4⁰)
3. **Powers of 2 that aren't powers of 4**: Return `false` (e.g., 2, 8, 32)

## Code Structure
All three solutions are efficient and handle edge cases correctly:
1. **Iterative Division**: Most intuitive and generalizable
2. **Bit Manipulation**: Most efficient and demonstrates advanced concepts
3. **Mathematical Properties**: Combines bit manipulation with mathematical insight

The bit manipulation approach is optimal for this specific problem and showcases important concepts in computer science.
