# Champagne Tower (Medium)

**Problem ID:** 799  
**Date:** 2026-02-14  
**Link:** https://leetcode.com/problems/champagne-tower/

## Approach

To solve the Champagne Tower problem, we can use a simulation approach that leverages a 2D array (or list) to represent the glasses in the pyramid structure. Each element in this array will hold the amount of champagne in that particular glass.

### Main Idea:
1. **Initialization**: Start by creating a 2D array `tower` where `tower[i][j]` represents the amount of champagne in the glass located at row `i` and glass `j`. Initialize all glasses to 0.

2. **Pouring Champagne**: Begin pouring champagne into the top glass (`tower[0][0]`). As champagne overflows from a glass, distribute the excess equally to the two glasses directly below it (i.e., `tower[i+1][j]` and `tower[i+1][j+1]`).

3. **Overflow Handling**: For each glass, if the amount of champagne exceeds 1 (indicating it is full), calculate the excess and distribute it to the glasses below. This is done iteratively for each glass in the pyramid until all poured champagne is accounted for or until we reach the maximum number of rows (100).

4. **Querying the Result**: After pouring the champagne, simply return the minimum of 1.0 and the amount in the queried glass (`tower[query_row][query_glass]`). This ensures that if the glass is full, we return 1.0, and if not, we return the actual amount.

### Data Structures:
- A 2D list (or array) `tower` of size 100x100 (or up to the maximum row needed) to store the champagne amounts in each glass.

### Complexity:
- **Time Complexity**: The algorithm runs in O(n^2) where n is the number of rows (up to 100), as each glass can potentially cause overflow to two glasses below it. Given the constraints, this is efficient.
- **Space Complexity**: O(n^2) due to the 2D list storing champagne amounts.

This approach efficiently simulates the pouring and overflow process while ensuring we can easily access the queried glass's champagne level.
