# Count Covered Buildings (Medium)

**Problem ID:** 3531  
**Date:** 2025-12-11  
**Link:** https://leetcode.com/problems/count-covered-buildings/

## Approach

To solve the "Count Covered Buildings" problem, we need to determine how many buildings in a given 2D grid are "covered," meaning each covered building has at least one other building in each of the four cardinal directions (up, down, left, right).

### Approach:

1. **Data Structures**:
   - Use a set to store the coordinates of the buildings for O(1) average-time complexity when checking if a building exists at a specific coordinate.
   - Additionally, maintain four sets (or dictionaries) to track the presence of buildings in each direction for every building:
     - `above`: stores buildings that can cover others from above.
     - `below`: stores buildings that can cover others from below.
     - `left`: stores buildings that can cover others from the left.
     - `right`: stores buildings that can cover others from the right.

2. **Processing the Buildings**:
   - Iterate through each building's coordinates. For each building located at `(x, y)`, check:
     - If there is a building at `(x-1, y)` (left).
     - If there is a building at `(x+1, y)` (right).
     - If there is a building at `(x, y-1)` (above).
     - If there is a building at `(x, y+1)` (below).
   - For each building, update the respective direction sets accordingly.

3. **Counting Covered Buildings**:
   - After processing all buildings, iterate through the original list of buildings again.
   - For each building, check if it has at least one building in all four direction sets. If it does, increment the count of covered buildings.

### Complexity:
- **Time Complexity**: O(m), where m is the number of buildings, since we are iterating through the list of buildings a couple of times.
- **Space Complexity**: O(m) as we store the coordinates in a set and potentially use additional sets for direction tracking.

This approach efficiently checks for coverage by leveraging set operations, ensuring that the solution is optimal even for the upper limits of the constraints.
