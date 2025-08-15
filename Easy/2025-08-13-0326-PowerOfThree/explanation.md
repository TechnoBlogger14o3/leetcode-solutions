# Power of Three

## Problem Description
Given an integer `n`, return `true` if it is a power of three. Otherwise, return `false`.

An integer `n` is a power of three if there exists an integer `x` such that `n == 3^x`.

## Approach

### Method 1: Iterative Division
The most straightforward approach is to keep dividing the number by 3 until we can't divide evenly anymore.

**Algorithm:**
1. Handle edge cases: return `false` for non-positive numbers, return `true` for 1
2. While the number is divisible by 3, keep dividing by 3
3. If we end up with 1, it's a power of 3; otherwise, it's not

**Time Complexity:** O(log₃ n) - we divide by 3 at most log₃ n times
**Space Complexity:** O(1) - constant extra space

### Method 2: Mathematical Properties
A more efficient approach uses the mathematical property that the largest power of 3 that fits in a 32-bit integer is 3¹⁹ = 1162261467.

**Algorithm:**
1. Check if n is positive
2. Check if 1162261467 is divisible by n
3. If both conditions are true, n is a power of 3

**Time Complexity:** O(1) - constant time operation
**Space Complexity:** O(1) - constant extra space

## Key Insights
1. **Powers of 3**: 1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467
2. **Divisibility Test**: If n is a power of 3, it must divide the largest power of 3 that fits in the data type
3. **Edge Cases**: 0 and negative numbers are never powers of 3, 1 is always a power of 3 (3⁰)

## Examples
- **n = 27**: 27 ÷ 3 = 9, 9 ÷ 3 = 3, 3 ÷ 3 = 1 → `true` (3³)
- **n = 0**: → `false` (not positive)
- **n = 9**: 9 ÷ 3 = 3, 3 ÷ 3 = 1 → `true` (3²)
- **n = 45**: 45 ÷ 3 = 15, 15 ÷ 3 = 5, 5 is not divisible by 3 → `false`

## Code Structure
Both solutions are clean and efficient:
1. **Iterative Division**: More intuitive and works for any base
2. **Mathematical Properties**: More efficient but specific to powers of 3

The iterative approach is more general and can be easily modified for other bases, while the mathematical approach is optimal for this specific problem.


