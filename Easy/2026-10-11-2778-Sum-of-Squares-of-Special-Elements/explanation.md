# Sum of Squares of Special Elements  (Easy)

**Problem ID:** 2778  
**Date:** 2026-10-11  
**Link:** https://leetcode.com/problems/sum-of-squares-of-special-elements/

## Approach

To solve the problem of calculating the sum of squares of special elements in the given integer array `nums`, we can follow a straightforward approach based on the properties of indices and divisibility.

### Approach:

1. **Identify Special Elements**: An element `nums[i]` is considered special if its index `i` (1-indexed) divides the length of the array `n` evenly, i.e., `n % i == 0`. This means we need to iterate through the indices of the array and check which of them are divisors of `n`.

2. **Calculate the Sum of Squares**: For each special index found, we will compute the square of the corresponding element `nums[i]` and accumulate this value into a running total.

3. **Data Structures**: We will primarily use a simple integer variable to keep track of the sum. No complex data structures are necessary due to the straightforward nature of the calculations.

4. **Complexity Analysis**: The solution involves a single pass through the array, checking each index up to `n`. Given that `n` can be at most 50 (as per the constraints), the time complexity is O(n). The space complexity is O(1) since we only use a few variables for calculations and do not require additional storage proportional to the input size.

### Summary:
The main idea is to iterate through the indices of the array, identify which indices are special based on their divisibility with `n`, and compute the sum of the squares of the elements at those indices. This approach is efficient and straightforward, making it suitable for the given problem constraints.
