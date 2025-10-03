# Trapping Rain Water II (Hard)

**Problem ID:** 407  
**Date:** 2025-10-03  
**Link:** https://leetcode.com/problems/trapping-rain-water-ii/

## Approach

To solve the "Trapping Rain Water II" problem, we can utilize a priority queue (min-heap) along with a breadth-first search (BFS) approach. The main idea is to simulate how water would flow and be trapped in a 2D elevation map by leveraging the concept of boundaries formed by the heights of the cells.

### Approach:

1. **Initialization**:
   - Use a priority queue to keep track of the boundary cells (cells on the edge of the height map) sorted by height. This allows us to always process the lowest boundary first, which is crucial for determining how much water can be trapped.
   - Create a boolean matrix to track which cells have been visited to avoid processing the same cell multiple times.

2. **Boundary Setup**:
   - Add all the boundary cells (the cells in the first and last rows and columns) to the priority queue and mark them as visited. These cells represent the initial boundaries of the water trapping area.

3. **BFS Process**:
   - While the priority queue is not empty, extract the cell with the lowest height. This cell will determine the maximum height of water that can be trapped in the adjacent cells.
   - For each of the four possible directions (up, down, left, right), check the neighboring cells:
     - If a neighboring cell is within bounds and has not been visited, calculate the potential water trapped above it as the difference between the current boundary height and the height of the neighboring cell (if positive).
     - Add this potential water volume to the total trapped water count.
     - Update the height of the neighboring cell to the maximum of its current height and the current boundary height (this effectively raises the boundary for future water trapping) and add it to the priority queue for further processing.

4. **Termination**:
   - The process continues until all reachable cells have been processed. The accumulated trapped water volume is then returned as the result.

### Data Structures:
- **Priority Queue (Min-Heap)**: To efficiently retrieve the lowest height cell for processing.
- **Boolean Matrix**: To track visited cells and avoid reprocessing.

### Complexity:
- **Time Complexity**: O(m * n * log(m * n)), where m and n are the dimensions of the height map. Each cell is processed once, and each insertion/removal from the priority queue takes logarithmic time relative to the number of cells.
- **Space Complexity**: O(m * n) for the visited matrix and the priority queue, which can hold all cells in the worst case.

This approach effectively simulates the water trapping process by always considering the lowest boundary first, ensuring that we accurately calculate the water volume that can be trapped in the 2D elevation map.
