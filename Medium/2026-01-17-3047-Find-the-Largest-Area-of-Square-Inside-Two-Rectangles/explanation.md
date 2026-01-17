# Find the Largest Area of Square Inside Two Rectangles (Medium)

**Problem ID:** 3047  
**Date:** 2026-01-17  
**Link:** https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/

## Approach

To solve the problem of finding the largest area of a square that can fit inside the intersecting region of at least two rectangles, we can follow this structured approach:

### Main Idea:
The core idea is to determine the intersection regions of every pair of rectangles and then compute the largest square that can fit within these intersections. The side length of the square will be constrained by the dimensions of the intersection.

### Steps:
1. **Identify Intersections**: For each pair of rectangles, calculate their intersection. The intersection of two rectangles defined by bottom-left coordinates \((a_i, b_i)\) and top-right coordinates \((c_i, d_i)\) can be computed as:
   - Bottom-left corner of the intersection: \((\max(a_i, a_j), \max(b_i, b_j))\)
   - Top-right corner of the intersection: \((\min(c_i, c_j), \min(d_i, d_j))\)

2. **Check Validity of Intersections**: After calculating the intersection coordinates, check if they form a valid rectangle. This is true if:
   - \(\max(a_i, a_j) < \min(c_i, c_j)\) (width is positive)
   - \(\max(b_i, b_j) < \min(d_i, d_j)\) (height is positive)

3. **Calculate Maximum Square Side**: For each valid intersection, determine the maximum side length of a square that can fit within that rectangle. This is given by the minimum of the intersection's width and height:
   - \( \text{side\_length} = \min(\min(c_i, c_j) - \max(a_i, a_j), \min(d_i, d_j) - \max(b_i, b_j)) \)

4. **Track the Largest Square Area**: Maintain a variable to track the maximum area of squares found during the iterations. The area can be calculated as:
   - \( \text{area} = \text{side\_length}^2 \)

5. **Return Result**: After checking all pairs of rectangles, return the maximum area found. If no valid intersections were found, return 0.

### Data Structures:
- Use two nested loops to iterate through pairs of rectangles, which requires storing the rectangle coordinates in lists or arrays. The complexity of this approach is primarily driven by the number of pairs, resulting in \(O(n^2)\) complexity for \(n\) rectangles.

### Complexity:
- **Time Complexity**: \(O(n^2)\), where \(n\) is the number of rectangles, due to the need to check every pair of rectangles.
- **Space Complexity**: \(O(1)\), as we only need a few variables to store the maximum area and the dimensions of intersections.

This approach efficiently finds the largest square area that can fit within the intersections of rectangles, leveraging geometric properties and simple calculations.
