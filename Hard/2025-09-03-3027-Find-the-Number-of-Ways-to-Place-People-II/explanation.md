# Find the Number of Ways to Place People II (Hard)

**Problem ID:** 3027  
**Date:** 2025-09-03  
**Link:** https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii/

## Approach

To solve the problem of finding the number of valid pairs of points where Alice and Bob can be placed without making Alice sad, we can follow this structured approach:

### Main Idea:
The core idea is to iterate through all possible pairs of points, treating one as Alice's position (upper left corner) and the other as Bob's position (lower right corner). We need to ensure that no other points lie inside or on the fence defined by these two positions. 

### Steps:
1. **Sorting Points**: First, sort the list of points based on their x-coordinates and, in case of ties, by their y-coordinates. This helps in efficiently checking the conditions for valid placements.

2. **Iterate Through Pairs**: Use a nested loop to iterate through all pairs of points (i, j) where point[i] is considered as Alice's position and point[j] as Bob's position. Ensure that Alice's x-coordinate is less than Bob's x-coordinate and Alice's y-coordinate is greater than Bob's y-coordinate to maintain the upper left and lower right corner constraints.

3. **Check for Other Points**: For each valid pair (i, j), check all other points to see if they fall within the rectangle defined by Alice and Bob. A point (x, y) is considered inside or on the fence if:
   - x-coordinate is between Alice's and Bob's x-coordinates.
   - y-coordinate is between Bob's and Alice's y-coordinates.

4. **Count Valid Pairs**: If no other point lies within the fence for a given pair (i, j), increment the count of valid pairs.

### Data Structures:
- A list to store the points, which can be sorted and iterated.
- Simple integer counters to keep track of valid pairs.

### Complexity:
- The sorting step takes O(n log n).
- The nested loop to check pairs takes O(n^2), and for each pair, checking other points takes O(n) in the worst case. Hence, the overall complexity is O(n^3) in the worst case.

### Conclusion:
The approach efficiently narrows down the valid placements of Alice and Bob by leveraging sorting and systematic pair checking, ensuring that we adhere to the constraints of the problem. The solution is feasible within the given constraints, as n is at most 1000, making O(n^3) manageable in practice.
