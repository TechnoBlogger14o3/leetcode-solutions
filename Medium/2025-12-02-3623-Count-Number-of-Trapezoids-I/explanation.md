# Count Number of Trapezoids I (Medium)

**Problem ID:** 3623  
**Date:** 2025-12-02  
**Link:** https://leetcode.com/problems/count-number-of-trapezoids-i/

## Approach

To solve the problem of counting unique horizontal trapezoids formed by a set of points on a Cartesian plane, we can follow a systematic approach:

### Problem Breakdown:
1. **Understanding Horizontal Trapezoids**: A horizontal trapezoid has at least one pair of parallel sides that are horizontal. This means we need to identify pairs of points that share the same y-coordinate (horizontal line).

2. **Data Structure**: We can utilize a dictionary (or hashmap) to group points by their y-coordinates. The key will be the y-coordinate, and the value will be a list of x-coordinates corresponding to that y-coordinate. This allows us to efficiently access all points that lie on a horizontal line.

### Steps to Solve:
1. **Group Points by Y-Coordinate**: Iterate through the list of points and populate the dictionary such that for each y-coordinate, we store the corresponding x-coordinates.

2. **Count Pairs of X-Coordinates**: For each y-level (each key in the dictionary), if there are `m` x-coordinates, the number of ways to choose 2 distinct x-coordinates (which will form the bases of the trapezoid) is given by the combination formula C(m, 2) = m * (m - 1) / 2.

3. **Calculate Trapezoids**: For each pair of y-levels (two different keys in the dictionary), multiply the number of ways to choose x-coordinates from the first y-level with the number of ways to choose x-coordinates from the second y-level. This product gives the number of trapezoids that can be formed with those two y-levels.

4. **Sum Up All Trapezoids**: Keep a running total of all trapezoids counted from all unique pairs of y-levels.

5. **Return Result Modulo**: Since the result can be large, return the final count modulo \(10^9 + 7\).

### Complexity Analysis:
- **Time Complexity**: The overall time complexity is O(n), where n is the number of points. This is because we are iterating through the list of points to group them by y-coordinates and then processing the pairs of y-levels, which is much smaller than n in most cases.
- **Space Complexity**: The space complexity is O(k), where k is the number of unique y-coordinates, as we store the x-coordinates for each unique y-level.

### Conclusion:
This approach efficiently counts the number of unique horizontal trapezoids by leveraging the properties of combinations and the organization of points into groups based on their y-coordinates, ensuring that we can handle the upper constraint of 100,000 points effectively.
