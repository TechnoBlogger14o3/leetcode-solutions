# Pyramid Transition Matrix (Medium)

**Problem ID:** 756  
**Date:** 2025-12-29  
**Link:** https://leetcode.com/problems/pyramid-transition-matrix/

## Approach

To solve the Pyramid Transition Matrix problem, we can use a depth-first search (DFS) approach combined with memoization to efficiently explore the possible configurations of the pyramid.

### Approach:

1. **Understanding the Structure**:
   - The pyramid is constructed from a base row of blocks, where each block can be represented by a character. Each pair of adjacent blocks in the current row can form a new block in the row above it based on the allowed triangular patterns.

2. **Data Structures**:
   - Use a set to store the allowed patterns for quick lookup.
   - Utilize a recursive function to explore the possible configurations of the pyramid. This function will take the current row of blocks as input and attempt to build the row above it.

3. **Recursive Function**:
   - The recursive function will check pairs of adjacent blocks in the current row. For each pair, it will look for all valid top blocks that can be formed using the allowed patterns.
   - For each valid top block found, the function will recursively call itself with the new row (which includes the newly formed top block) until reaching the top of the pyramid (when the row has only one block).

4. **Base Case**:
   - The recursion stops when the row length is 1, indicating that the pyramid has been successfully built.

5. **Memoization**:
   - To optimize the function, store results of previously computed states (current row) to avoid redundant calculations. This can be done using a dictionary where keys are the current row strings and values indicate whether that configuration can lead to a valid pyramid.

6. **Complexity**:
   - The time complexity is primarily influenced by the number of states explored and the number of allowed patterns. Given the constraints, the worst-case scenario involves exploring multiple configurations, but memoization drastically reduces the number of unique states. The space complexity is also O(n) due to the storage of the memoization dictionary.

### Summary:
By leveraging DFS and memoization, we can efficiently explore all possible configurations of the pyramid, checking against the allowed patterns to determine if a valid pyramid can be formed from the given base row. This approach ensures that we systematically build the pyramid while avoiding unnecessary recalculations, making it feasible within the problem’s constraints.
