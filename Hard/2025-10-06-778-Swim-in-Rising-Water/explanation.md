# Swim in Rising Water (Hard)

**Problem ID:** 778  
**Date:** 2025-10-06  
**Link:** https://leetcode.com/problems/swim-in-rising-water/

## Approach

To solve the "Swim in Rising Water" problem, we can utilize a combination of a priority queue (min-heap) and a breadth-first search (BFS) strategy to efficiently determine the minimum time required to reach the bottom-right corner of the grid from the top-left corner.

### Main Idea:
The key insight is that the problem can be viewed as a pathfinding problem where the cost of moving through a cell is determined by the water level (time `t`). The goal is to find the minimum `t` such that there exists a path from the starting cell `(0, 0)` to the target cell `(n-1, n-1)` where all cells in the path have elevations less than or equal to `t`.

### Approach:
1. **Min-Heap for Priority Queue**: Use a min-heap to explore cells in the order of their elevation values. This allows us to always consider the lowest elevation cell that is reachable at the current water level.
  
2. **BFS with Priority Queue**: Start from the top-left cell `(0, 0)` and push it into the min-heap. While the heap is not empty:
   - Extract the cell with the minimum elevation (this represents the current water level we can swim at).
   - Check if this cell is the bottom-right cell. If it is, the elevation at this cell is the minimum time required to reach it.
   - Otherwise, explore the 4-directionally adjacent cells (up, down, left, right). For each adjacent cell, if it is within bounds and has not been visited, push it into the heap with its elevation.

3. **Visited Set**: Maintain a set to keep track of visited cells to prevent reprocessing and infinite loops.

### Data Structures:
- **Min-Heap (Priority Queue)**: To efficiently get the cell with the minimum elevation.
- **Set/Array for Visited Cells**: To track which cells have already been processed.

### Complexity:
- **Time Complexity**: O(n^2 log(n)), where n is the dimension of the grid. Each cell is pushed and popped from the heap once, and heap operations take logarithmic time.
- **Space Complexity**: O(n^2) for the visited set and the heap, which can store all cells in the worst case.

This approach ensures that we find the minimum time required to swim to the target cell while efficiently managing the elevation constraints imposed by the grid.
