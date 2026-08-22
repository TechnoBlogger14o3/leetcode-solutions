# Check Divisibility by Digit Sum and Product (Easy)

**Problem ID:** 3622  
**Date:** 2026-08-22  
**Link:** https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/

## Approach

To solve the problem of checking the divisibility of a positive integer \( n \) by the sum of its digit sum and digit product, we can follow these steps:

1. **Extract Digits**: Convert the integer \( n \) into its individual digits. This can be done by repeatedly taking the modulus of 10 and performing integer division by 10 until \( n \) becomes zero. Alternatively, we can convert \( n \) to a string and iterate over each character.

2. **Calculate Digit Sum and Product**:
   - **Digit Sum**: Initialize a variable to accumulate the sum of the digits as you extract them.
   - **Digit Product**: Initialize another variable to accumulate the product of the digits. Start this variable at 1 (since multiplying by 0 would yield 0) and update it as you extract each digit.

3. **Compute Total**: Once you have both the digit sum and digit product, compute the total by adding these two values together.

4. **Check Divisibility**: Finally, check if \( n \) is divisible by the computed total. This can be done using the modulus operator. If \( n \mod \text{total} = 0 \), return true; otherwise, return false.

### Complexity Analysis:
- **Time Complexity**: The time complexity is \( O(d) \), where \( d \) is the number of digits in \( n \). Given the constraint \( 1 \leq n \leq 10^6 \), \( d \) can be at most 7 (for numbers like 9999999).
- **Space Complexity**: The space complexity is \( O(1) \) since we are using a constant amount of space for storing the digit sum and product, regardless of the size of \( n \).

### Main Idea:
The main idea is to decompose the number into its digits, compute the necessary sum and product, and then check the divisibility condition. This approach is straightforward and efficient given the problem constraints.
