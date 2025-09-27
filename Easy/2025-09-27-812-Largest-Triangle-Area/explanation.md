# Largest Triangle Area (Easy)

**Problem ID:** 812  
**Date:** 2025-09-27  
**Link:** https://leetcode.com/problems/largest-triangle-area/

## Approach

To solve the problem of finding the largest triangle area that can be formed from a set of points on the X-Y plane, we can leverage the mathematical formula for the area of a triangle given its vertices. The area \( A \) of a triangle formed by three points \((x_1, y_1)\), \((x_2, y_2)\), and \((x_3, y_3)\) can be calculated using the determinant formula:

\[
A = \frac{1}{2} \left| x_1(y_2 - y_3) + x_2(y_3 - y_1) + x_3(y_1 - y_2) \right|
\]

### Approach:

1. **Iterate through Combinations**: Since we need to consider all possible triangles formed by three distinct points, we can use a triple nested loop to iterate through all combinations of three points from the input list. Given the constraints (maximum 50 points), this results in a manageable number of combinations.

2. **Calculate Area**: For each combination of three points, we apply the area formula to compute the area of the triangle they form.

3. **Track Maximum Area**: Maintain a variable to keep track of the maximum area encountered during the iterations. After evaluating all combinations, this variable will hold the area of the largest triangle.

### Data Structures:
- A list (or array) to store the points, which are given as pairs of coordinates.
- A variable to store the maximum area found during the iterations.

### Complexity:
- **Time Complexity**: The approach has a time complexity of \( O(n^3) \), where \( n \) is the number of points. This is acceptable given the constraints (with \( n \) up to 50).
- **Space Complexity**: The space complexity is \( O(1) \) beyond the input storage, as we only need a few variables to track the maximum area and intermediate calculations.

### Conclusion:
This systematic approach ensures that we evaluate all possible triangles efficiently and accurately, ultimately returning the largest triangle area with the required precision.
