# Apply Operations on Array to Maximize Sum of Squares (Hard)

**Problem ID:** 2897  
**Date:** 2026-10-12  
**Link:** https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/

## Approach

To solve the problem of maximizing the sum of squares from an array after applying a series of operations, we can follow a structured approach:

### Main Idea:
The operations allowed (AND and OR) can significantly alter the values in the array. The key insight is that through these operations, we can combine elements to create larger values, particularly by focusing on the maximum values in the array. The goal is to maximize the sum of the squares of the top `k` elements after performing the operations optimally.

### Steps to Approach:

1. **Understanding the Operations**:
   - The operation on two elements `nums[i]` and `nums[j]` results in:
     - `nums[i]` becomes `nums[i] AND nums[j]`
     - `nums[j]` becomes `nums[i] OR nums[j]`
   - This means that after applying the operations, one number can be reduced while the other can be increased, potentially leading to larger maximum values.

2. **Identify Key Elements**:
   - Since we want to maximize the sum of squares, we should focus on the largest values in the array. 
   - The operations can be used to combine smaller elements into larger ones, but we should also consider the original values.

3. **Use a Max-Heap**:
   - To efficiently retrieve the largest `k` elements, we can utilize a max-heap (or a priority queue). This allows us to keep track of the largest values dynamically as we potentially modify the array.

4. **Iterate and Combine**:
   - We can iterate through the array and perform operations to combine elements, pushing the results back into the max-heap. 
   - After processing, we will extract the top `k` elements from the heap.

5. **Calculate the Sum of Squares**:
   - Once we have the top `k` elements, we compute the sum of their squares and return the result modulo \(10^9 + 7\).

### Data Structures:
- **Max-Heap**: To efficiently manage and retrieve the largest elements.
- **Array/List**: To store the modified values during the operations.

### Complexity:
- The time complexity is primarily determined by the operations on the heap and the number of elements in the array. Inserting and extracting from a heap is \(O(\log n)\), leading to an overall complexity of \(O(n \log k)\) for extracting the top `k` elements after processing the array.
- The space complexity is \(O(n)\) for storing the elements in the heap.

### Conclusion:
By focusing on the largest elements and leveraging the operations to maximize their values, we can efficiently compute the maximum sum of squares. The combination of a max-heap and careful management of operations enables us to achieve the desired outcome within the problem's constraints.
