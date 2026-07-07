# Concatenate Non-Zero Digits and Multiply by Sum I (Easy)

**Problem ID:** 3754  
**Date:** 2026-07-07  
**Link:** https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/

## Approach

To solve the problem of concatenating non-zero digits from an integer `n` and multiplying the result by the sum of those digits, we can follow a straightforward approach:

1. **Extract Non-Zero Digits**: We will iterate through each digit of the integer `n`. This can be achieved by converting the integer to a string, which allows us to easily access each digit.

2. **Concatenate Non-Zero Digits**: As we iterate through the digits, we will check if each digit is non-zero. If it is, we will append it to a result string (or list) that will hold the non-zero digits in their original order.

3. **Calculate Sum of Digits**: Simultaneously, we can maintain a running sum of the non-zero digits. This can be done by converting each non-zero character back to an integer and adding it to a sum variable.

4. **Handle Edge Cases**: If there are no non-zero digits found, we should set `x` to 0. Otherwise, we convert the concatenated string of non-zero digits back to an integer.

5. **Calculate Final Result**: Finally, we return the product of `x` (the concatenated integer) and `sum` (the sum of the non-zero digits).

### Data Structures:
- A string (or list) to hold the concatenated non-zero digits.
- An integer variable to keep track of the sum of non-zero digits.

### Complexity:
- **Time Complexity**: O(d), where d is the number of digits in `n`. This is efficient since we only traverse the digits once.
- **Space Complexity**: O(d) in the worst case for storing the non-zero digits, although the actual space used could be less if there are few non-zero digits.

This approach ensures that we efficiently extract the required values and compute the result in a clear and concise manner.
