# Maximum Side Length of a Square with Sum Less than or Equal to Threshold (Medium)

**Problem ID:** 1292  
**Date:** 2026-01-19  
**Link:** https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/

## Approach

To solve the problem of finding the maximum side length of a square with a sum less than or equal to a given threshold in a matrix, we can employ a combination of prefix sums and binary search.

### Approach:

1. **Prefix Sum Calculation**:
   - First, we create a prefix sum matrix that allows us to compute the sum of any sub-square in constant time. The prefix sum at position `(i, j)` represents the sum of all elements in the sub-matrix from the top-left corner `(0, 0)` to `(i, j)`.
   - The prefix sum can be computed using the formula:
     \[
     \text{prefix}[i][j] = \text{mat}[i][j] + \text{prefix}[i-1][j] + \text{prefix}[i][j-1] - \text{prefix}[i-1][j-1]
     \]
   - This allows us to efficiently calculate the sum of any square sub-matrix.

2. **Binary Search for Maximum Side Length**:
   - We can use binary search to determine the largest possible side length `k` for which we can find a square of size `k x k` with a sum less than or equal to the threshold.
   - The search range for `k` is from `0` to `min(m, n)` (the dimensions of the matrix).

3. **Checking Validity of Side Length**:
   - For each candidate side length `k`, we iterate over all possible top-left corners of `k x k` squares in the matrix. For each position `(i, j)`, we calculate the sum of the square using the prefix sum matrix.
   - If the sum is less than or equal to the threshold, we can consider `k` as a valid side length.

4. **Complexity**:
   - The prefix sum computation takes \(O(m \times n)\).
   - The binary search runs in \(O(\log(\min(m, n)))\) iterations.
   - For each iteration of the binary search, checking all possible squares of size `k` requires \(O((m-k+1) \times (n-k+1))\), which in the worst case can be approximated as \(O(m \times n)\).
   - Thus, the overall time complexity is \(O(m \times n \log(\min(m, n)))\).

### Summary:
The main idea is to utilize a prefix sum matrix to facilitate quick sum calculations of square sub-matrices and to apply binary search to efficiently find the maximum side length of a square that meets the sum constraint. This approach balances preprocessing with efficient querying, making it suitable for the problem's constraints.
