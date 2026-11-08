# Count Servers that Communicate (Medium)

**Problem ID:** 1267  
**Date:** 2026-11-08  
**Link:** https://leetcode.com/problems/count-servers-that-communicate/

## Approach

To solve the problem of counting servers that can communicate in a given grid, we can adopt the following approach:

### Main Idea:
The core idea is to identify servers that can communicate with at least one other server. Two servers can communicate if they are in the same row or the same column. Therefore, we need to keep track of the number of servers in each row and each column.

### Steps:
1. **Count Servers in Rows and Columns**: 
   - Create two arrays: `rowCount` and `colCount`. 
   - Traverse the grid and for each server (cell with value 1), increment the corresponding entry in `rowCount` and `colCount`.

2. **Identify Communicating Servers**:
   - After populating the counts, traverse the grid again. For each server found, check the corresponding values in `rowCount` and `colCount`.
   - A server can communicate if either its row count or column count is greater than 1. If this condition is satisfied, increment a counter for communicating servers.

### Data Structures:
- Two arrays (`rowCount` and `colCount`) of size equal to the number of rows and columns respectively, to store the count of servers in each row and column.

### Complexity:
- **Time Complexity**: O(m * n), where m is the number of rows and n is the number of columns. This is because we traverse the grid twice: once for counting and once for determining communication.
- **Space Complexity**: O(m + n) for the two count arrays.

This approach efficiently counts the number of servers that can communicate by leveraging simple counting techniques and ensures that we stay within the problem's constraints.
