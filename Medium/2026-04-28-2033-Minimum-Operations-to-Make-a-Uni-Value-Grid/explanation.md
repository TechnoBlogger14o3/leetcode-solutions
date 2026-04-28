# Minimum Operations to Make a Uni-Value Grid (Medium)

**Problem ID:** 2033  
**Date:** 2026-04-28  
**Link:** https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

## Approach

To solve the problem of transforming a 2D grid into a uni-value grid using the minimum number of operations, we can follow these steps:

### Main Idea:
The goal is to determine if all elements in the grid can be made equal by adding or subtracting a given integer `x`. If it is possible, we need to calculate the minimum number of operations required to achieve this.

### Steps to Approach:
1. **Check Feasibility**: 
   - First, we need to ensure that all elements in the grid can be transformed into the same value. This is only possible if the difference between any two elements in the grid is a multiple of `x`. 
   - To check this, we can compute the difference between the first element and all other elements. If any of these differences is not divisible by `x`, we can immediately return `-1` as it is impossible to make the grid uni-value.

2. **Determine Target Value**:
   - If it is feasible, we can choose a target value to which all elements will be transformed. A common strategy is to use the median of the grid values. The median minimizes the total distance (and thus the number of operations) required to make all values equal.

3. **Calculate Operations**:
   - For each element in the grid, calculate the number of operations needed to convert it to the target value. This can be done by taking the absolute difference between the element and the target value, then dividing by `x` to get the number of operations.

### Data Structures:
- A simple 2D array (the grid itself) is used to store the input values.
- A list or array can be used to store the values of the grid for easier manipulation when calculating the median and operations.

### Complexity:
- The time complexity of this approach is `O(m * n)` for checking feasibility and calculating operations, where `m` and `n` are the dimensions of the grid. The space complexity is also `O(m * n)` for storing the grid values if we need to extract them into a separate list.

In summary, the solution involves checking the feasibility of making all elements equal based on the divisibility condition, selecting a target value (preferably the median), and calculating the total operations needed to transform all elements to this target. If the feasibility check fails, we return `-1`.
