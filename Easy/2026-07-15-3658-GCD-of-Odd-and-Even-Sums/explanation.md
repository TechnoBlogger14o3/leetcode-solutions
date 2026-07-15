# GCD of Odd and Even Sums (Easy)

**Problem ID:** 3658  
**Date:** 2026-07-15  
**Link:** https://leetcode.com/problems/gcd-of-odd-and-even-sums/

## Approach

To solve the problem of finding the GCD of the sums of the smallest \( n \) positive odd and even numbers, we can leverage mathematical formulas instead of iterating through each number.

### Main Idea:
1. **Sum of Odd Numbers**: The sum of the first \( n \) positive odd numbers can be expressed as:
   \[
   \text{sumOdd} = n^2
   \]
   This is derived from the formula for the sum of the first \( n \) odd numbers.

2. **Sum of Even Numbers**: The sum of the first \( n \) positive even numbers can be expressed as:
   \[
   \text{sumEven} = n(n + 1)
   \]
   This is derived from the formula for the sum of the first \( n \) even numbers.

3. **GCD Calculation**: Once we have both sums, we can compute the GCD using the properties of GCD. Specifically, we can use the relationship:
   \[
   \text{GCD}(a, b) = \text{GCD}(a, b - a \cdot \lfloor b/a \rfloor)
   \]
   However, since we are dealing with simple expressions, we can directly compute the GCD of \( n^2 \) and \( n(n + 1) \).

### Steps:
1. Calculate \( \text{sumOdd} = n^2 \).
2. Calculate \( \text{sumEven} = n(n + 1) \).
3. Compute the GCD of \( n^2 \) and \( n(n + 1) \).

### Data Structures:
No complex data structures are needed for this problem, as we only need basic arithmetic operations and a method to compute the GCD.

### Complexity:
- **Time Complexity**: The time complexity is \( O(\log(\min(a, b))) \) for the GCD calculation, where \( a \) and \( b \) are the sums. Given that \( n \) can be as large as \( 10^3 \), this is efficient.
- **Space Complexity**: \( O(1) \) since we are using a constant amount of space for computations.

In summary, the problem can be efficiently solved using mathematical formulas for the sums of odd and even numbers, followed by a straightforward GCD calculation.
