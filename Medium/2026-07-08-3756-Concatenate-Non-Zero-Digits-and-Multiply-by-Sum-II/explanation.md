# Concatenate Non-Zero Digits and Multiply by Sum II (Medium)

**Problem ID:** 3756  
**Date:** 2026-07-08  
**Link:** https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/

## Approach

To solve the problem "Concatenate Non-Zero Digits and Multiply by Sum II", we can adopt the following approach:

### Main Idea:
The goal is to efficiently process multiple queries on the string `s`, each querying a substring defined by indices `[l, r]`. For each substring, we need to extract non-zero digits, concatenate them into an integer `x`, compute the sum of these digits, and then return the product of `x` and the sum, modulo \(10^9 + 7\).

### Steps:
1. **Preprocessing Non-Zero Digits**:
   - Create a new string or list that contains only the non-zero digits from `s` while maintaining their order. This allows for faster access during query processing.
   - Simultaneously, maintain a prefix sum array that keeps track of the cumulative sum of the digits at each index for quick sum calculations.

2. **Handling Queries**:
   - For each query defined by indices `[l, r]`, extract the relevant substring.
   - Use the preprocessed non-zero digits string to find the corresponding non-zero digits within the substring.
   - If there are no non-zero digits, set `x` to 0. Otherwise, concatenate the non-zero digits to form `x`.
   - Calculate the sum of the digits in `x` using the prefix sum array to quickly get the sum of digits in the substring.
   - Compute the result as `result = (x * sum) % (10^9 + 7)`.

### Data Structures:
- A list or string for storing non-zero digits.
- A prefix sum array for the cumulative sum of digits.

### Complexity:
- **Preprocessing**: O(m), where `m` is the length of the string `s`. This includes creating the non-zero digit list and the prefix sum array.
- **Query Processing**: Each query can be processed in O(n) time in the worst case, where `n` is the length of the substring. However, since we can directly access the non-zero digits and their sums using the preprocessed data, the effective complexity for each query can be reduced significantly.
- **Overall Complexity**: O(m + q * n), where `q` is the number of queries and `n` is the average length of the substring being queried. Given the constraints, this approach is efficient and feasible.

By following this structured approach, we ensure that we handle potentially large inputs efficiently while adhering to the problem's constraints.
