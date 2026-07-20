# Shift 2D Grid (Easy)

**Problem ID:** 1260  
**Date:** 2026-07-20  
**Link:** https://leetcode.com/problems/shift-2d-grid/

## Approach

To solve the "Shift 2D Grid" problem, we can utilize a straightforward approach based on the properties of the grid and the shifting operation.

### Main Idea:
The primary goal is to shift the elements of the 2D grid `k` times to the right. Instead of performing `k` individual shifts, which would be inefficient, we can optimize the process by recognizing that shifting the grid `m * n` times (where `m` is the number of rows and `n` is the number of columns) results in the same configuration as the original grid. Thus, we can reduce `k` to `k % (m * n)`.

### Steps to Approach:
1. **Flatten the Grid**: Convert the 2D grid into a 1D list for easier manipulation. This allows us to treat the grid as a linear array.
  
2. **Calculate Effective Shifts**: Compute the effective number of shifts needed using `k = k % (m * n)`. If `k` is 0, the grid remains unchanged.

3. **Perform the Shift**: To shift the elements, we can slice the 1D array:
   - The last `k` elements will move to the front.
   - The first `m * n - k` elements will follow.
   This can be done using list slicing.

4. **Reconstruct the Grid**: After obtaining the shifted 1D array, convert it back into a 2D grid by iterating through the new list and filling up the original grid structure.

### Data Structures:
- A list to hold the flattened version of the grid.
- A new list to store the shifted version before reconstructing the 2D grid.

### Complexity:
- **Time Complexity**: O(m * n), where `m` is the number of rows and `n` is the number of columns. This is because we need to visit each element to flatten the grid and then to reconstruct it.
- **Space Complexity**: O(m * n) for the 1D representation of the grid.

This approach is efficient and leverages the properties of array manipulation to achieve the desired result with minimal overhead.
