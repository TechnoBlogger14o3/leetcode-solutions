# Smallest Divisible Digit Product I (Easy)

**Problem ID:** 3345  
**Date:** 2026-08-06  
**Link:** https://leetcode.com/problems/smallest-divisible-digit-product-i/

## Approach

To solve the problem of finding the smallest number greater than or equal to `n` such that the product of its digits is divisible by `t`, we can follow a straightforward iterative approach.

### Main Idea:
1. **Iterate from n**: Start checking from the integer `n` and incrementally check each subsequent integer.
2. **Calculate Digit Product**: For each integer, calculate the product of its digits.
3. **Check Divisibility**: Check if the calculated product is divisible by `t`. If it is, that number is our answer.

### Steps:
- **Initialization**: Begin with the current number set to `n`.
- **Loop**: Use a while loop to check each number starting from `n`.
  - Convert the number to its digits.
  - Calculate the product of the digits.
  - If the product is divisible by `t`, return that number.
- **Increment**: If the product is not divisible, increment the number and repeat the process.

### Data Structures:
- **Integer**: To track the current number.
- **List/Array**: To hold the digits of the current number for product calculation (though this can also be done using simple arithmetic).

### Complexity:
- **Time Complexity**: In the worst case, we might check every number starting from `n` up to `100`, which is manageable given the constraints. The digit product calculation involves at most two iterations (for two digits), making the overall complexity O(d * m), where `d` is the number of digits (at most 3 for numbers up to 100) and `m` is the number of checks (up to 100).
- **Space Complexity**: O(1) if we consider only the space used for variables, as we are not using any additional data structures that grow with input size.

This approach is efficient given the constraints and ensures that we find the smallest number satisfying the condition in a straightforward manner.
