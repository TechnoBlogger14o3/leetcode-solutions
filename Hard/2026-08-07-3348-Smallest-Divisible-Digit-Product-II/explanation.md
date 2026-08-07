# Smallest Divisible Digit Product II (Hard)

**Problem ID:** 3348  
**Date:** 2026-08-07  
**Link:** https://leetcode.com/problems/smallest-divisible-digit-product-ii/

## Approach

To solve the problem of finding the smallest zero-free number greater than or equal to a given string representation of a positive integer `num`, with the additional requirement that the product of its digits is divisible by a given integer `t`, we can adopt the following approach:

### Problem-Solving Approach

1. **Understanding Zero-Free Numbers**: A zero-free number is one that does not contain the digit '0'. Therefore, any candidate number must consist solely of digits from '1' to '9'.

2. **Incremental Search**: The simplest way to find a valid number is to start from `num` and incrementally check each subsequent number. However, this brute-force approach would be inefficient due to the constraints (up to 200,000 digits).

3. **Digit Manipulation**: Instead of checking every number, we can manipulate the digits of `num`:
   - Convert `num` to a list of digits for easier manipulation.
   - Starting from the least significant digit, increment the number while ensuring it remains zero-free. If a digit reaches '9', it rolls over to '1' and increments the next more significant digit.

4. **Checking Divisibility**: For each candidate number generated:
   - Calculate the product of its digits.
   - Check if this product is divisible by `t`. If it is, this number is a valid candidate.

5. **Early Stopping**: If we find a valid number, we can stop further checks. If we exhaust all possibilities without finding a valid number, we return "-1".

### Data Structures
- Use a list to manipulate the digits of the number easily.
- Use integer arithmetic to compute the product of the digits.

### Complexity
- The worst-case time complexity can be approximated as O(n * d), where `n` is the number of digits in `num` and `d` is the number of digits we might need to check before finding a valid zero-free number. Given the constraints, this approach is efficient enough since we are not generating all numbers but rather incrementally adjusting the digits.

### Summary
The main idea is to incrementally build the smallest zero-free number by manipulating the digits of `num`, checking each candidate for the product divisibility condition. This approach leverages digit manipulation and avoids brute-force checking of every number, making it feasible for large inputs.
