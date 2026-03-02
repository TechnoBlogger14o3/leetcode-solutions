# Minimum Swaps to Arrange a Binary Grid (Medium)

**Problem ID:** 1536  
**Date:** 2026-03-02  
**Link:** https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/

## Approach

To solve the problem of finding the minimum number of swaps needed to arrange a binary grid such that all cells above the main diagonal are zeros, we can follow these steps:

### Main Idea:
The key to solving this problem is to recognize that for each row in the grid, we need to determine how many zeros are at the end of the row. This will help us identify how many rows can be swapped to achieve the desired configuration.

### Approach:
1. **Count Trailing Zeros**: For each row in the grid, count the number of trailing zeros. This count will determine how far down the row can be moved to achieve a valid configuration. Store these counts in a list.

2. **Determine Valid Rows**: Starting from the top row (index 0) to the bottom row (index n-1), for each row `i`, we need to ensure that there are at least `n - i - 1` zeros available in the rows below it (including itself). This is because for row `i`, we need `n - i - 1` zeros to fill the positions above the main diagonal.

3. **Greedy Swapping**: For each row `i`, find the first row `j` (where `j >= i`) that has enough trailing zeros to satisfy the requirement. If such a row is found, we can swap it to the `i`th position. Count the number of swaps required to bring this row to the `i`th position. If no such row exists, it means it's impossible to make the grid valid, and we return -1.

4. **Repeat**: Continue this process for each row until either the grid is valid or it is determined that it cannot be made valid.

### Data Structures:
- An array (or list) to store the count of trailing zeros for each row.
- A loop to iterate through the rows and perform the necessary checks and swaps.

### Complexity:
- **Time Complexity**: O(n^2) in the worst case, where `n` is the number of rows (or columns) in the grid. This is due to the nested iteration to find rows with sufficient trailing zeros.
- **Space Complexity**: O(n) for storing the counts of trailing zeros.

By following this structured approach, we can efficiently determine the minimum number of swaps required to make the binary grid valid or conclude that it is impossible.
