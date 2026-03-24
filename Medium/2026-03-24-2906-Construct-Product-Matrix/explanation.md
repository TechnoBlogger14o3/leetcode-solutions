# Construct Product Matrix (Medium)

**Problem ID:** 2906  
**Date:** 2026-03-24  
**Link:** https://leetcode.com/problems/construct-product-matrix/

## Approach

To solve the problem of constructing the product matrix from a given 2D integer matrix `grid`, we need to compute each element `p[i][j]` as the product of all elements in `grid` except for `grid[i][j]`, and then take the result modulo `12345`. 

### Approach:

1. **Calculate the Total Product**: 
   - First, compute the total product of all elements in the matrix `grid`. This can be done by iterating through each element and multiplying them together while taking care to apply the modulo operation to prevent overflow. 

2. **Construct the Product Matrix**:
   - For each element `grid[i][j]`, calculate `p[i][j]` as the total product divided by `grid[i][j]`. However, since we are working with modulo arithmetic, we cannot directly divide. Instead, we can use the property of modular multiplicative inverses to compute the result. Specifically, we can find the modular inverse of `grid[i][j]` with respect to `12345`.
   - The modular inverse can be computed using Fermat's Little Theorem since `12345` is not prime. We can use the Extended Euclidean Algorithm to find the modular inverse.

3. **Handle Edge Cases**:
   - If any element in `grid` is `0`, the total product will be `0`, and all elements in the product matrix will also be `0` except for the position corresponding to the `0` in `grid`, which will be the product of all non-zero elements.

### Data Structures:
- A simple 2D list (matrix) to store the product matrix.
- Variables to hold the total product and the modular inverse.

### Complexity:
- **Time Complexity**: O(n * m), where `n` is the number of rows and `m` is the number of columns. This is due to the need to iterate through the entire matrix to compute the total product and then again to construct the product matrix.
- **Space Complexity**: O(n * m) for the output matrix. The space used for storing the total product and the modular inverse is O(1).

This approach efficiently computes the product matrix while adhering to the constraints provided, ensuring that we handle large numbers and modular arithmetic correctly.
