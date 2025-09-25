# Triangle (Medium)

**Problem ID:** 120  
**Date:** 2025-09-25  
**Link:** https://leetcode.com/problems/triangle/

## Approach

To solve the "Triangle" problem, we can use a dynamic programming approach. The main idea is to compute the minimum path sum from the bottom of the triangle to the top, modifying the triangle in place to store the minimum sums.

### Approach:

1. **Dynamic Programming Table**: We can treat the triangle itself as our DP table. Starting from the second-to-last row, we will update each element to represent the minimum path sum from that element to the bottom of the triangle.

2. **Bottom-Up Calculation**:
   - For each element `triangle[i][j]`, we can calculate the minimum path sum to the bottom by considering the two adjacent elements directly below it in the next row: `triangle[i+1][j]` and `triangle[i+1][j+1]`.
   - The update rule will be:
     \[
     triangle[i][j] = triangle[i][j] + \min(triangle[i+1][j], triangle[i+1][j+1])
     \]
   - This process continues until we reach the top of the triangle.

3. **Final Result**: After processing all rows, the top element `triangle[0][0]` will contain the minimum path sum from the top to the bottom of the triangle.

### Data Structures:
- We utilize the given triangle array as our data structure for dynamic programming, which allows us to achieve the required space efficiency.

### Complexity:
- **Time Complexity**: O(n^2), where n is the number of rows in the triangle. Each element is processed once.
- **Space Complexity**: O(1) additional space, as we modify the triangle in place without using any extra data structures.

### Follow-Up:
The in-place modification of the triangle ensures that we meet the requirement of using only O(n) extra space, as we are not allocating additional arrays for storing intermediate results. 

By following this approach, we efficiently compute the minimum path sum while adhering to the constraints provided in the problem statement.
