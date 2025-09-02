# Find the Number of Ways to Place People I (Medium)

**Problem ID:** 3025  
**Date:** 2025-09-02  
**Link:** https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/

## Approach

To solve the problem of counting the number of valid pairs of points (A, B) such that A is in the upper left quadrant relative to B and no other points exist within the rectangle formed by A and B (including the borders), we can follow this structured approach:

### Main Idea:
1. **Sorting Points**: First, sort the points based on their x-coordinates and then by y-coordinates. This helps in systematically checking pairs while ensuring that we only consider valid pairs where A is indeed to the upper left of B.

2. **Nested Pair Checking**: For each point A, iterate through all subsequent points B. For each pair (A, B):
   - Check if A is indeed to the upper left of B, which can be verified using the conditions:
     - \( A[0] < B[0] \) (x-coordinate condition)
     - \( A[1] < B[1] \) (y-coordinate condition)

3. **Rectangle Validation**: For each valid pair (A, B), check if any other point lies within the rectangle defined by A and B. This can be done by iterating through all points and checking if any point (C) satisfies:
   - \( A[0] < C[0] < B[0] \) and \( A[1] < C[1] < B[1] \)
   If such a point exists, the pair is invalid.

4. **Counting Valid Pairs**: Maintain a counter to keep track of the number of valid pairs (A, B) that satisfy the conditions.

### Data Structures:
- **List**: To store the points and facilitate sorting.
- **Nested Loops**: For iterating through pairs of points and checking for other points within the rectangle.

### Complexity:
- **Time Complexity**: The approach involves sorting the points, which takes \( O(n \log n) \), followed by a nested loop to check pairs, leading to \( O(n^2) \) for the pair checking. The overall complexity is \( O(n^2) \), which is efficient given the constraints (with \( n \) up to 50).
- **Space Complexity**: The space used is primarily for storing the points, which is \( O(n) \).

This approach ensures that we efficiently count the valid pairs while adhering to the problem's constraints and requirements.
