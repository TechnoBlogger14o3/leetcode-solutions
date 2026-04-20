# Two Furthest Houses With Different Colors (Easy)

**Problem ID:** 2078  
**Date:** 2026-04-20  
**Link:** https://leetcode.com/problems/two-furthest-houses-with-different-colors/

## Approach

To solve the problem of finding the maximum distance between two houses with different colors, we can adopt a straightforward approach that leverages the properties of the array and the constraints provided.

### Main Idea:
The core idea is to identify the first and last occurrences of the two distinct colors present in the array. By focusing on the two endpoints (first and last occurrences) of the houses with different colors, we can directly calculate the maximum distance.

### Approach:
1. **Identify Distinct Colors**: Start by identifying the first and last indices of the two colors that are different from each other. Since the problem guarantees that there are at least two houses with different colors, we can safely proceed with this step.

2. **Calculate Distances**: The maximum distance can be calculated by considering:
   - The distance between the first house of one color and the last house of the other color.
   - The distance between the last house of one color and the first house of the other color.

3. **Return the Maximum Distance**: Finally, compute the distances from the two scenarios above and return the maximum of the two.

### Data Structures:
- An array to hold the colors of the houses, which is already provided as input.
- Simple integer variables to keep track of the first and last indices of the colors.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the colors array. This is because we only need to traverse the array a couple of times to find the required indices.
- **Space Complexity**: O(1), as we are using a constant amount of extra space regardless of the input size.

This approach is efficient and effective given the constraints, ensuring that we can quickly determine the maximum distance between two houses with different colors.
