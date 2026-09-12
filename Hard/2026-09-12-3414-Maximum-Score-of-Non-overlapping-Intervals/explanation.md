# Maximum Score of Non-overlapping Intervals (Hard)

**Problem ID:** 3414  
**Date:** 2026-09-12  
**Link:** https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/

## Approach

To solve the problem of finding the maximum score of non-overlapping intervals, we can use a combination of sorting, dynamic programming, and a greedy approach. Here's a concise explanation of the solution approach:

### Main Idea
The goal is to select up to 4 non-overlapping intervals such that their total weight is maximized. We need to ensure that the selected intervals do not overlap and return the lexicographically smallest indices of these intervals in case of ties.

### Steps to Solve the Problem

1. **Sorting**: Start by sorting the intervals based on their end times. This helps in efficiently checking for overlaps and allows us to use a greedy approach to select intervals.

2. **Dynamic Programming (DP)**: Use a DP array where `dp[i][j]` represents the maximum score obtainable by considering the first `i` intervals and selecting up to `j` intervals. The dimensions of this DP table will be `n x 5`, where `n` is the number of intervals.

3. **Transition**:
   - For each interval `i`, decide whether to include it in the selection or not.
   - If included, find the last non-overlapping interval `k` (using binary search for efficiency).
   - Update the DP table based on whether you include the current interval or not:
     - If not included: `dp[i][j] = dp[i-1][j]`
     - If included: `dp[i][j] = max(dp[i][j], dp[k][j-1] + weight[i])`

4. **Tracking Indices**: Maintain a separate structure to keep track of the indices of selected intervals for reconstructing the solution later. This can be done by storing the chosen intervals alongside their weights in the DP table.

5. **Final Selection**: After filling the DP table, the maximum score will be found in `dp[n][1]`, `dp[n][2]`, `dp[n][3]`, or `dp[n][4]`. To retrieve the indices, backtrack through the DP table to find which intervals contributed to the maximum score.

### Data Structures
- **DP Table**: A 2D array for dynamic programming to store maximum weights.
- **List of Intervals**: To store the original intervals and their indices for reconstruction.

### Complexity
- **Time Complexity**: O(n log n) due to sorting and O(n) for filling the DP table, leading to a total of O(n log n).
- **Space Complexity**: O(n) for the DP table and additional space for storing indices.

This approach efficiently finds the maximum score of non-overlapping intervals while ensuring that the selected indices are lexicographically smallest in case of ties.
