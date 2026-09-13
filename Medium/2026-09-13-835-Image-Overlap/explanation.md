# Image Overlap (Medium)

**Problem ID:** 835  
**Date:** 2026-09-13  
**Link:** https://leetcode.com/problems/image-overlap/

## Approach

To solve the "Image Overlap" problem, we need to determine the maximum overlap of two binary matrices, `img1` and `img2`, by translating one of them in various directions. The key steps in the approach are as follows:

### Main Idea:
1. **Translation and Overlap Calculation**: We can translate `img1` in all possible directions (left, right, up, down) relative to `img2`. For each translation position, we will calculate the overlap, which is defined as the number of positions where both matrices have a `1`.

2. **Shifting Logic**: Given that both matrices are of size `n x n`, we can translate `img1` by shifting it within the bounds of the matrix. The possible translations can be represented by offsets in both the x (horizontal) and y (vertical) directions.

3. **Overlap Counting**: For each translation, we will iterate through the overlapping regions of the matrices and count how many positions have a `1` in both matrices.

### Data Structures:
- We will use simple 2D arrays (or lists) to represent `img1` and `img2`.
- A variable to keep track of the maximum overlap found during the iterations.

### Steps:
1. **Iterate Over Possible Translations**: For each possible translation defined by `(dx, dy)` where `dx` and `dy` can range from `-n + 1` to `n - 1` (inclusive), we will calculate the overlap.
  
2. **Calculate Overlap**:
   - For each translation `(dx, dy)`, determine the range of indices in `img1` and `img2` that will overlap.
   - Count the number of overlapping `1`s by iterating through the overlapping area and checking the corresponding positions in both images.

3. **Update Maximum Overlap**: After calculating the overlap for each translation, update the maximum overlap found.

### Complexity:
- The time complexity is O(n^4). This is because:
  - There are O(n^2) possible translations (each defined by two dimensions).
  - For each translation, we might need to check an O(n^2) area for overlaps.
- The space complexity is O(1) since we only use a few variables for counting and tracking the maximum overlap, without requiring additional data structures that grow with input size.

This approach efficiently explores all translation possibilities and calculates overlaps to determine the maximum overlap between the two binary images.
