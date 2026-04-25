# Maximize the Distance Between Points on a Square (Hard)

**Problem ID:** 3464  
**Date:** 2026-04-25  
**Link:** https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/

## Approach

To solve the problem of maximizing the minimum Manhattan distance between selected points on the boundary of a square, we can employ a binary search combined with a backtracking approach.

### Main Idea:
The goal is to select `k` points from the given boundary points such that the minimum Manhattan distance between any two selected points is maximized. We can think of the problem in terms of feasibility: for a given distance `d`, we need to determine if it is possible to select `k` points such that every pair of selected points has a Manhattan distance of at least `d`.

### Approach:
1. **Binary Search**: 
   - We will perform a binary search on the possible values of the minimum distance. The lower bound (`low`) can be set to `0`, and the upper bound (`high`) can be the maximum possible Manhattan distance between two points on the square's boundary, which is `2 * side`.

2. **Feasibility Check**:
   - For a mid-value `d` (the current guess for the minimum distance), we will check if it is possible to select `k` points such that the Manhattan distance between any two selected points is at least `d`.
   - This can be done using a backtracking approach or a greedy selection strategy:
     - Start by selecting the first point.
     - For each subsequent point, check if it maintains the required distance `d` from all previously selected points. If it does, include it in the selection.
     - Continue this until either `k` points are selected or all points have been checked.

3. **Data Structures**:
   - A simple list or array can be used to store the points.
   - A recursive function or iterative loop can be used for the backtracking feasibility check.

### Complexity:
- The binary search runs in `O(log(max_distance))`, where `max_distance` is `2 * side`.
- The feasibility check can take `O(n * k)` in the worst case, where `n` is the number of points. This is because for each point, we may need to check against all previously selected points.
- Overall, the time complexity can be approximated as `O(n * k * log(max_distance))`, which is efficient given the constraints.

By combining binary search with an efficient feasibility check, we can effectively determine the maximum possible minimum Manhattan distance for selecting `k` points on the square's boundary.
