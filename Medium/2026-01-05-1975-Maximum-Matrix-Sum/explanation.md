# Maximum Matrix Sum (Medium)

**Problem ID:** 1975  
**Date:** 2026-01-05  
**Link:** https://leetcode.com/problems/maximum-matrix-sum/

## Approach

To solve the problem of maximizing the sum of an n x n integer matrix after performing the specified operation (multiplying two adjacent elements by -1), we can follow these steps:

### Problem Understanding
The key operation allows us to change the sign of two adjacent elements in the matrix. This means that we can effectively flip the sign of pairs of elements, which can help us increase the overall sum of the matrix. The goal is to determine the maximum possible sum after performing any number of such operations.

### Approach
1. **Calculate the Initial Sum**: Start by calculating the initial sum of all elements in the matrix. This will serve as a baseline for our calculations.

2. **Identify Negative Elements**: Count the number of negative elements in the matrix. The presence of negative elements is crucial since they will contribute negatively to the overall sum.

3. **Determine the Minimum Absolute Value**: Find the element with the smallest absolute value in the matrix. This value will be important for deciding how to handle the sign flips.

4. **Evaluate the Effect of Flips**:
   - If the count of negative elements is even, we can flip pairs of negatives to make them positive, maximizing the sum without any remaining negatives.
   - If the count of negative elements is odd, one negative will remain after all possible flips. In this case, we can flip the smallest absolute value element (which could be either negative or positive) to minimize the negative impact on the sum.

5. **Calculate the Maximum Sum**:
   - If there are an even number of negatives, the maximum sum is simply the absolute value of the initial sum.
   - If there are an odd number of negatives, the maximum sum can be calculated as:
     \[
     \text{max\_sum} = \text{initial\_sum} + 2 \times \text{smallest\_absolute\_value}
     \]
   This accounts for flipping the smallest absolute value element to mitigate the effect of the remaining negative.

### Data Structures
- A simple 2D array (matrix) to store the input values.
- Variables to keep track of the initial sum, count of negative elements, and the smallest absolute value.

### Complexity
- **Time Complexity**: O(n^2) due to the need to iterate through all elements of the n x n matrix to calculate the initial sum, count negatives, and find the minimum absolute value.
- **Space Complexity**: O(1) since we are using a constant amount of extra space regardless of the input size.

### Conclusion
By leveraging the properties of the operations allowed and focusing on the count of negative numbers and the smallest absolute value, we can efficiently compute the maximum possible sum of the matrix after performing the operations. This approach ensures that we handle both even and odd counts of negative elements appropriately to achieve the desired result.
