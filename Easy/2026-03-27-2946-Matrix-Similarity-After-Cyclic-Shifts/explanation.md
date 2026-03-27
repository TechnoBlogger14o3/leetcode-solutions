# Matrix Similarity After Cyclic Shifts (Easy)

**Problem ID:** 2946  
**Date:** 2026-03-27  
**Link:** https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/

## Approach

To solve the problem of determining whether a matrix remains identical after performing a series of cyclic shifts, we can break down the approach into a few key steps:

### Main Idea:
The core idea is to simulate the cyclic shifts for both even and odd indexed rows of the matrix, but instead of actually shifting the rows multiple times, we can derive the final positions of the elements after `k` shifts. This avoids unnecessary computations and allows us to directly compare the modified matrix with the original.

### Steps:
1. **Understand Cyclic Shifts**:
   - A left cyclic shift on an even-indexed row moves each element to the left, and the first element wraps around to the end.
   - A right cyclic shift on an odd-indexed row moves each element to the right, and the last element wraps around to the front.

2. **Effective Shifts**:
   - For any row of length `n`, performing `k` shifts is equivalent to performing `k % n` shifts, since shifting `n` times results in the same row.
   - For even-indexed rows, calculate the new index for each element after `k` left shifts.
   - For odd-indexed rows, calculate the new index for each element after `k` right shifts.

3. **Construct the Modified Matrix**:
   - Create a new matrix where each element is placed in its new position based on the calculated indices from the previous step.

4. **Comparison**:
   - Finally, compare the newly constructed matrix with the original matrix. If they are identical, return `true`; otherwise, return `false`.

### Data Structures:
- A 2D list (matrix) to hold the original and modified matrices.
- Simple integer arithmetic to compute new indices based on the shift operations.

### Complexity:
- The time complexity is O(m * n), where `m` is the number of rows and `n` is the number of columns in the matrix. This is because we need to iterate through each element to determine its new position.
- The space complexity is also O(m * n) due to the storage of the modified matrix.

By following this structured approach, we can efficiently determine if the matrix remains unchanged after the specified cyclic shifts.
