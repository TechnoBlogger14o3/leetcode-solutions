# Minimum Swaps to Sort by Digit Sum (Medium)

**Problem ID:** 3551  
**Date:** 2026-10-17  
**Link:** https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/

## Approach

To solve the problem of finding the minimum number of swaps required to sort an array based on the digit sums of its elements, we can follow these steps:

### Main Idea:
1. **Calculate Digit Sums**: For each number in the array, compute the sum of its digits. This will serve as the primary key for sorting.
2. **Sort by Digit Sum**: Create a sorted version of the array based on the digit sums. If two numbers have the same digit sum, the smaller number should come first.
3. **Determine Minimum Swaps**: Use a cycle detection approach to count the minimum number of swaps needed to transform the original array into the sorted array.

### Detailed Steps:
1. **Compute Digit Sums**: Create a helper function to calculate the digit sum for each number in the array. Store these sums along with their original indices in a list of tuples.
   
2. **Sort the Array**: Sort the list of tuples based on the digit sums and then by the original numbers. This gives us the target order.

3. **Map Indices**: Create a mapping from the original indices to the sorted indices. This helps in identifying where each element should go.

4. **Cycle Detection**:
   - Initialize a visited array to keep track of which elements have already been placed correctly.
   - For each unvisited element, trace the cycle of indices that need to be swapped to place the elements in their correct positions.
   - The number of swaps required to sort a cycle of length `k` is `k - 1`.

### Data Structures:
- Use a list of tuples to store the digit sums along with their original indices.
- Use a boolean array to track visited indices during cycle detection.

### Complexity:
- **Time Complexity**: O(n log n) due to the sorting step, where n is the number of elements in the array. The digit sum calculation is O(n) and the cycle detection is O(n).
- **Space Complexity**: O(n) for storing the digit sums and original indices.

By following this structured approach, we efficiently determine the minimum number of swaps required to sort the array based on the digit sums.
