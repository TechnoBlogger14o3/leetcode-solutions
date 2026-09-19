# Circle and Rectangle Overlapping (Medium)

**Problem ID:** 1401  
**Date:** 2026-09-19  
**Link:** https://leetcode.com/problems/circle-and-rectangle-overlapping/

## Approach

To solve the problem of determining whether a circle overlaps with a rectangle, we can break down the approach into a series of logical steps.

### Main Idea:
The core idea is to check the distance from the center of the circle to the closest point on the rectangle. If this distance is less than or equal to the radius of the circle, then the circle and rectangle overlap. If the distance is greater than the radius, they do not overlap.

### Steps:
1. **Identify the Closest Point on the Rectangle**: 
   - Given the rectangle defined by its bottom-left corner (x1, y1) and top-right corner (x2, y2), we can determine the closest point on the rectangle to the circle's center (xCenter, yCenter).
   - The x-coordinate of the closest point can be computed as:
     - If `xCenter < x1`, then the closest x-coordinate is `x1`.
     - If `xCenter > x2`, then the closest x-coordinate is `x2`.
     - Otherwise, it is `xCenter` (within the rectangle's x-bounds).
   - The y-coordinate is similarly computed:
     - If `yCenter < y1`, then the closest y-coordinate is `y1`.
     - If `yCenter > y2`, then the closest y-coordinate is `y2`.
     - Otherwise, it is `yCenter` (within the rectangle's y-bounds).

2. **Calculate the Distance**: 
   - Once we have the closest point (closestX, closestY) on the rectangle, we can calculate the squared distance from the circle's center to this point using the formula:
     \[
     \text{distance}^2 = (closestX - xCenter)^2 + (closestY - yCenter)^2
     \]
   - This avoids the computational cost of taking a square root.

3. **Compare with Radius**: 
   - Finally, we compare the squared distance to the square of the radius:
     \[
     \text{distance}^2 \leq radius^2
     \]
   - If this condition holds, the circle and rectangle overlap; otherwise, they do not.

### Data Structures:
- No complex data structures are needed; simple variables are sufficient to store coordinates and distances.

### Complexity:
- The time complexity of this approach is O(1) since it involves a constant number of arithmetic operations regardless of the input size.
- The space complexity is also O(1) as we are using a fixed amount of space for calculations.

By following this structured approach, we can efficiently determine if the circle and rectangle overlap.
