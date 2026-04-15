# Shortest Distance to Target String in a Circular Array (Easy)

**Problem ID:** 2515  
**Date:** 2026-04-15  
**Link:** https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/

## Approach

To solve the problem of finding the shortest distance to a target string in a circular array of words, we can follow a straightforward approach:

### Problem Breakdown:
1. **Circular Array Concept**: The array is circular, meaning we can wrap around from the end of the array back to the beginning. This means we can move both left and right from any index.
  
2. **Identify Target Indices**: First, we need to identify all indices in the `words` array where the `target` string exists. This can be done by iterating through the `words` array.

3. **Calculate Distances**: For each index where the `target` is found, we calculate the distance from the `startIndex`. The distance can be calculated in two ways:
   - **Rightward Distance**: This is simply the difference between the target index and the start index, adjusted for circularity using modulo operation.
   - **Leftward Distance**: This is the total length of the array minus the rightward distance, which accounts for moving in the opposite direction.

4. **Determine the Shortest Distance**: After calculating the distances for all occurrences of the target, the minimum of these distances will be our answer. If no occurrences of the target are found, we return -1.

### Data Structures:
- A list to store indices of occurrences of the target.
- Simple integer variables to keep track of distances.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the `words` array. This is because we traverse the array once to find target indices and compute distances.
- **Space Complexity**: O(m), where m is the number of occurrences of the target in `words`. This space is used to store the indices of the target.

### Summary:
The approach effectively utilizes a linear scan to gather necessary indices and then computes the shortest distance considering the circular nature of the array. This ensures that we efficiently find the desired result while maintaining clarity and simplicity in the solution.
