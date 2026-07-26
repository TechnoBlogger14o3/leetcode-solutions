# Maximum Product of Three Numbers (Easy)

**Problem ID:** 628  
**Date:** 2026-07-26  
**Link:** https://leetcode.com/problems/maximum-product-of-three-numbers/

## Approach

To solve the problem of finding the maximum product of three numbers from an integer array, we can utilize a straightforward approach based on identifying key candidates for the maximum product.

### Main Idea:
The maximum product of three numbers can be obtained in two possible scenarios:
1. The product of the three largest numbers in the array.
2. The product of the two smallest numbers (which could be negative) and the largest number (to leverage the negative sign for a potentially larger positive product).

### Approach:
1. **Sorting**: First, sort the array. This allows us to easily access the largest and smallest numbers.
2. **Calculate Candidates**:
   - The product of the three largest numbers: `nums[n-1] * nums[n-2] * nums[n-3]`, where `n` is the length of the sorted array.
   - The product of the two smallest numbers and the largest number: `nums[0] * nums[1] * nums[n-1]`.
3. **Return the Maximum**: The final result will be the maximum of the two products calculated above.

### Data Structures:
- We primarily use an array to store the input numbers. Sorting the array will take O(n log n) time, and accessing the required elements will take O(1) time.

### Complexity:
- **Time Complexity**: O(n log n) due to the sorting step.
- **Space Complexity**: O(1) if we sort in place, or O(n) if we consider the space used by the sorting algorithm itself.

This approach is efficient given the problem constraints and ensures that we consider all potential combinations for maximizing the product.
