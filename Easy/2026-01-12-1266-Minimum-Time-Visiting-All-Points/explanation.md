# Minimum Time Visiting All Points (Easy)

**Problem ID:** 1266  
**Date:** 2026-01-12  
**Link:** https://leetcode.com/problems/minimum-time-visiting-all-points/

## Approach

To solve the problem of finding the minimum time required to visit all points in a given order on a 2D plane, we can leverage the properties of movement in the grid. The key points of the approach are as follows:

### Main Idea:
1. **Movement Rules**: You can move one unit vertically, horizontally, or diagonally in one second. The diagonal movement allows you to cover both x and y directions simultaneously, which is crucial for minimizing time.
  
2. **Distance Calculation**: For each pair of consecutive points, the time taken to move from point A (x1, y1) to point B (x2, y2) can be calculated using the formula:
   - `time = max(|x2 - x1|, |y2 - y1|)`
   This formula arises because moving diagonally allows you to reduce both the x and y distances simultaneously. The maximum of the absolute differences in x and y coordinates determines the total time taken to reach the next point.

### Steps to Solve:
1. **Iterate through Points**: Start from the first point and iterate through each consecutive pair of points in the list.
2. **Calculate Time for Each Segment**: For each segment between point i and point i+1, compute the time using the formula mentioned above.
3. **Accumulate Total Time**: Keep a running total of the time taken as you move from point to point.

### Data Structures:
- A simple list (or array) to hold the points is sufficient, as we only need to access the coordinates of each point in sequence.

### Complexity:
- **Time Complexity**: O(n), where n is the number of points. We perform a constant-time operation (calculating the max of two values) for each of the n-1 segments between points.
- **Space Complexity**: O(1), as we are using a fixed amount of extra space for variables and do not require additional data structures that scale with input size.

This approach is efficient and straightforward, leveraging the properties of grid movement to minimize the time required to visit all points in the specified order.
