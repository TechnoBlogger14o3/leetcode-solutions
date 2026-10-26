# Count Islands With Total Value Divisible by K (Medium)

**Problem ID:** 3619  
**Date:** 2026-10-26  
**Link:** https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/

## Approach

To solve the problem of counting islands with a total value divisible by \( k \) in a given matrix, we can use a depth-first search (DFS) or breadth-first search (BFS) approach to explore the islands in the grid. Here’s a concise explanation of the approach:

### Main Idea
1. **Identify Islands**: An island is defined as a group of connected positive integers (land) in the grid. We will traverse the grid to identify these islands.
2. **Calculate Total Value**: For each island found, we will calculate the total value by summing the integers that make up the island.
3. **Check Divisibility**: After calculating the total value of an island, we will check if it is divisible by \( k \). If it is, we increment our count of valid islands.

### Approach
1. **Traversal**: Iterate through each cell in the grid. If a cell contains a positive integer and has not been visited, it indicates the start of a new island.
2. **DFS/BFS for Exploration**: Use DFS or BFS to explore all cells connected to the starting cell (the current land cell). During this exploration:
   - Maintain a running total of the island's value.
   - Mark cells as visited to avoid counting them multiple times.
3. **Count Valid Islands**: After completing the exploration of an island, check if the total value is divisible by \( k \). If it is, increase the count of valid islands.

### Data Structures
- **Visited Set/Matrix**: To keep track of which cells have already been counted as part of an island.
- **Stack/Queue**: For implementing DFS or BFS to explore the island cells.

### Complexity
- **Time Complexity**: \( O(m \times n) \) where \( m \) is the number of rows and \( n \) is the number of columns in the grid. Each cell is visited at most once.
- **Space Complexity**: \( O(m \times n) \) in the worst case for the visited structure, and \( O(\min(m, n)) \) for the recursion stack in DFS.

This approach efficiently counts the number of islands with a total value divisible by \( k \) while ensuring that all cells are processed systematically.
