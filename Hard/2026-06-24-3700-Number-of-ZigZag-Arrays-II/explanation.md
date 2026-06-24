# Number of ZigZag Arrays II (Hard)

**Problem ID:** 3700  
**Date:** 2026-06-24  
**Link:** https://leetcode.com/problems/number-of-zigzag-arrays-ii/

## Approach

To solve the problem of counting the number of valid ZigZag arrays of length \( n \) with elements in the range \([l, r]\), we can utilize a combinatorial approach combined with dynamic programming principles.

### Main Idea:
The key to solving this problem is to recognize the constraints imposed by the ZigZag definition. Specifically, we need to ensure that:
1. No two adjacent elements are equal.
2. No three consecutive elements form a strictly increasing or strictly decreasing sequence.

Given the constraints, we can break down the problem into manageable parts by focusing on how to construct valid sequences iteratively.

### Approach:
1. **Dynamic Programming Setup**: 
   - Define two states:
     - `dp[i][0]`: The number of valid ZigZag arrays of length \( i \) that end with a "peak" (the last element is greater than the previous one).
     - `dp[i][1]`: The number of valid ZigZag arrays of length \( i \) that end with a "valley" (the last element is less than the previous one).
   - The total number of valid arrays of length \( i \) would then be \( dp[i][0] + dp[i][1] \).

2. **Transitions**:
   - For a ZigZag array of length \( i \):
     - If it ends in a peak, the previous element must be a valley, and vice versa.
     - The transitions can be defined based on the valid choices for the last element given the previous element's value.
     - We can calculate the number of valid transitions based on the available numbers in the range \([l, r]\).

3. **Counting Valid Transitions**:
   - For any chosen last element, we need to count how many valid previous elements can be chosen that maintain the ZigZag properties.
   - This involves ensuring that we do not pick the same number as the last element and avoid creating three consecutive elements that violate the ZigZag condition.

4. **Final Count**:
   - After constructing the states iteratively up to length \( n \), the final answer will be the sum of `dp[n][0]` and `dp[n][1]`.

### Data Structures:
- We will primarily use integer variables to keep track of the counts for `dp[i][0]` and `dp[i][1]`, as the size of \( n \) can be very large (up to \( 10^9 \)). Thus, we will need to optimize our calculations to avoid storing large arrays.

### Complexity:
- The time complexity is primarily determined by the number of valid transitions we can compute, which is manageable due to the limited range of values (up to 75). The overall complexity is \( O(1) \) for each step in terms of \( n \) since we can derive the next states based on previous counts without needing to store all intermediate states.

### Modulo Operation:
- Since the final result can be large, we will take all results modulo \( 10^9 + 7 \) to ensure we do not encounter overflow issues.

By following this structured approach, we can efficiently compute the number of valid ZigZag arrays for any given \( n \), \( l \), and \( r \).
