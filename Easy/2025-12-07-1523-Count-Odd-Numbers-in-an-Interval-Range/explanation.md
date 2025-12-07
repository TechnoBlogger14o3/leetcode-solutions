# Count Odd Numbers in an Interval Range (Easy)

**Problem ID:** 1523  
**Date:** 2025-12-07  
**Link:** https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

## Approach

To solve the problem of counting odd numbers in a given inclusive range defined by two non-negative integers, `low` and `high`, we can leverage a mathematical approach rather than iterating through the range.

### Main Idea:
The key observation is that odd numbers follow a predictable pattern. Specifically:
- Odd numbers are of the form `2n + 1`, where `n` is a non-negative integer.
- To count the odd numbers between two integers, we can determine how many odd numbers exist up to `high` and how many exist up to `low - 1`. The difference between these two counts will give us the total number of odd numbers in the range `[low, high]`.

### Steps:
1. **Count Odd Numbers Up to `high`:**
   - If `high` is even, the count of odd numbers up to `high` is `high // 2`.
   - If `high` is odd, the count is `(high // 2) + 1`.

2. **Count Odd Numbers Up to `low - 1`:**
   - Similarly, if `low - 1` is even, the count is `(low - 1) // 2`.
   - If `low - 1` is odd, the count is `((low - 1) // 2) + 1`.

3. **Calculate the Result:**
   - The total count of odd numbers in the range `[low, high]` is given by:
     \[
     \text{count\_odds}(high) - \text{count\_odds}(low - 1)
     \]

### Complexity:
- **Time Complexity:** O(1), since the solution involves a constant number of arithmetic operations regardless of the size of the input.
- **Space Complexity:** O(1), as no additional data structures are used.

This approach efficiently calculates the number of odd integers in the specified range without the need for explicit iteration, making it suitable for large input values up to \(10^9\).
