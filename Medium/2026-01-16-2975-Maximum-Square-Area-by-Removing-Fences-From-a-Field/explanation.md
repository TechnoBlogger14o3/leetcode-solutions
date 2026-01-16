# Maximum Square Area by Removing Fences From a Field (Medium)

**Problem ID:** 2975  
**Date:** 2026-01-16  
**Link:** https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/

## Approach

To solve the problem of finding the maximum square area that can be formed by removing fences from a rectangular field, we can follow these steps:

### Problem Breakdown
1. **Understanding the Field and Fences**: The field is defined by its dimensions `(m, n)`, and the fences are provided in two arrays: `hFences` for horizontal fences and `vFences` for vertical fences. The goal is to determine the largest square area that can be formed by potentially removing some of these fences.

2. **Identifying Possible Square Sizes**: The maximum possible square side length is limited by the dimensions of the field, specifically `min(m-1, n-1)`. We need to check for each possible square size from `1` to this maximum value.

### Approach
1. **Calculate Gaps Between Fences**:
   - First, we need to compute the effective gaps between the fences. For horizontal fences, we can include the boundaries of the field (i.e., `0` and `m`) to calculate the gaps. For vertical fences, we do the same with `0` and `n`.
   - Sort the arrays `hFences` and `vFences` to facilitate the calculation of gaps.

2. **Determine Maximum Gaps**:
   - For horizontal gaps, calculate the maximum distance between consecutive horizontal fences, including the boundaries. This gives us the largest possible height for a square.
   - Similarly, for vertical gaps, calculate the maximum distance between consecutive vertical fences to determine the largest possible width for a square.

3. **Finding the Maximum Square Size**:
   - The maximum side length of the square that can be formed is the minimum of the largest horizontal gap and the largest vertical gap. This is because a square requires equal width and height.

4. **Output the Area**:
   - If the maximum side length is greater than or equal to `1`, compute the area as `side_length^2` and return it modulo `10^9 + 7`. If no square can be formed (i.e., the maximum side length is less than `1`), return `-1`.

### Data Structures
- Arrays for storing the horizontal and vertical fence positions.
- Sorting will be used to arrange the fences for gap calculations.

### Complexity
- The time complexity is dominated by the sorting step, which is `O(k log k)` where `k` is the maximum length of the `hFences` or `vFences` arrays (up to `600`).
- The space complexity is `O(k)` for the arrays used to store fence positions.

By following this approach, we can efficiently determine the maximum square area that can be formed in the given field while considering the constraints of the fences.
