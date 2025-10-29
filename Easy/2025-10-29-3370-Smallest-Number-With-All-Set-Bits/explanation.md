# Smallest Number With All Set Bits (Easy)

**Problem ID:** 3370  
**Date:** 2025-10-29  
**Link:** https://leetcode.com/problems/smallest-number-with-all-set-bits/

## Approach

To solve the problem of finding the smallest number \( x \) greater than or equal to \( n \) such that \( x \) has all bits set in its binary representation, we can follow a systematic approach:

### Main Idea:
The smallest number with all bits set in binary is represented as \( 2^k - 1 \), where \( k \) is the number of bits. For example:
- \( k = 1 \): \( 2^1 - 1 = 1 \) (binary: 1)
- \( k = 2 \): \( 2^2 - 1 = 3 \) (binary: 11)
- \( k = 3 \): \( 2^3 - 1 = 7 \) (binary: 111)
- \( k = 4 \): \( 2^4 - 1 = 15 \) (binary: 1111)

Given a number \( n \), we need to find the smallest \( k \) such that \( 2^k - 1 \geq n \).

### Approach:
1. **Initialization**: Start with \( k = 1 \).
2. **Iterate**: Calculate \( 2^k - 1 \) for increasing values of \( k \) until the result is greater than or equal to \( n \).
3. **Return the Result**: Once the condition \( 2^k - 1 \geq n \) is satisfied, return \( 2^k - 1 \).

### Data Structures:
- No complex data structures are needed; simple integer variables will suffice to store \( k \) and the result.

### Complexity:
- **Time Complexity**: The loop runs until \( k \) reaches a value such that \( 2^k \) exceeds \( n + 1 \). Given the constraint \( n \leq 1000 \), \( k \) will be at most around 10 (since \( 2^{10} = 1024 \)). Thus, the time complexity is \( O(1) \).
- **Space Complexity**: The space complexity is \( O(1) \) as we are using a fixed number of variables.

This method efficiently finds the smallest number with all set bits that meets the criteria without the need for complex calculations or data structures.
