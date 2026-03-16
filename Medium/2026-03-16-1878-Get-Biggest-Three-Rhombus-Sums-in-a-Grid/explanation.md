# Get Biggest Three Rhombus Sums in a Grid (Medium)

**Problem ID:** 1878  
**Date:** 2026-03-16  
**Link:** https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/

## Approach

To solve the problem of finding the biggest three distinct rhombus sums in a grid, we can follow a systematic approach:

### Main Idea:
The key is to calculate the rhombus sums centered at each cell in the grid for varying sizes of rhombuses. A rhombus can be defined by its "radius," which determines how far we extend from the center cell. We need to compute the sums for all possible rhombus sizes and then collect these sums, ensuring they are distinct, before returning the top three.

### Steps:
1. **Iterate through the grid**: For each cell in the grid, treat it as a potential center of a rhombus.
  
2. **Calculate rhombus sums**: For each cell, calculate the rhombus sums for increasing sizes (radii). The rhombus of radius `r` includes:
   - The center cell.
   - Cells diagonally up to `r` units away in both directions (up, down, left, right).
   - The contributions to the sum can be calculated by iterating over the rows and columns that form the rhombus shape.

3. **Store distinct sums**: Use a set to store the rhombus sums to ensure they are distinct.

4. **Sort and select top sums**: Convert the set of sums to a list, sort it in descending order, and extract the top three sums. If there are fewer than three distinct sums, return all of them.

### Data Structures:
- **Set**: To store distinct rhombus sums efficiently.
- **List**: To sort the sums and retrieve the top three.

### Complexity:
- **Time Complexity**: The algorithm involves iterating through each cell (O(m * n)) and calculating rhombus sums for varying sizes. The maximum radius is limited by the smaller dimension of the grid, leading to a complexity of O(m * n * min(m, n)). Given the constraints (m, n ≤ 50), this is manageable.
- **Space Complexity**: The space used for storing sums in a set is O(k), where k is the number of distinct sums. In the worst case, this could be O(m * n).

This approach ensures that we efficiently compute the required sums while maintaining distinctness and allows us to retrieve the largest sums in a straightforward manner.
