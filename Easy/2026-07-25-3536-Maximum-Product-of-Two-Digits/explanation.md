# Maximum Product of Two Digits (Easy)

**Problem ID:** 3536  
**Date:** 2026-07-25  
**Link:** https://leetcode.com/problems/maximum-product-of-two-digits/

## Approach

To solve the problem of finding the maximum product of any two digits in a given positive integer \( n \), we can follow a straightforward approach:

### Problem-Solving Approach:

1. **Extract Digits**: Convert the integer \( n \) into its individual digits. This can be done by repeatedly dividing \( n \) by 10 and storing the remainders, or by converting \( n \) to a string and then mapping each character back to an integer.

2. **Calculate Products**: Once we have the list of digits, we need to compute the products of every possible pair of digits. Since the problem allows the same digit to be used twice, we will consider both combinations of distinct digits and pairs of the same digit.

3. **Track Maximum Product**: As we compute the products, we will maintain a variable to keep track of the maximum product found. This can be initialized to zero, and we will update it whenever we find a product that is greater than the current maximum.

4. **Return Result**: After evaluating all pairs, we will return the maximum product.

### Data Structures:
- A list or array to store the digits of \( n \).
- A variable to store the maximum product.

### Complexity:
- **Time Complexity**: The time complexity is \( O(d^2) \), where \( d \) is the number of digits in \( n \). Given the constraints (with \( n \) having at most 10 digits), this is efficient.
- **Space Complexity**: The space complexity is \( O(d) \) for storing the digits.

### Summary:
The main idea is to extract the digits of \( n \), compute the products of all possible pairs, and track the maximum product found. This method efficiently handles the constraints and allows for straightforward implementation.
