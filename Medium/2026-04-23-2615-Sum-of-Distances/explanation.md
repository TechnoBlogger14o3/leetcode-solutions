# Sum of Distances (Medium)

**Problem ID:** 2615  
**Date:** 2026-04-23  
**Link:** https://leetcode.com/problems/sum-of-distances/

## Approach

To solve the problem of calculating the sum of distances for each element in the `nums` array, we can adopt a systematic approach that efficiently computes the required values using a combination of data structures and mathematical insights.

### Problem Breakdown
1. **Understanding Distance Calculation**: For each index `i`, we need to sum the absolute differences `|i - j|` for all indices `j` where `nums[j] == nums[i]` and `j != i`. This can be simplified by recognizing that the absolute difference can be calculated based on the relative positions of `i` and `j`.

2. **Grouping Indices**: We can use a dictionary to group indices of the same value in `nums`. This allows us to efficiently access all indices corresponding to each unique value.

### Approach
1. **Index Mapping**: Create a dictionary where each key is a unique value from `nums`, and the value is a list of indices where this key appears.

2. **Distance Calculation**:
   - For each unique value, retrieve its list of indices.
   - Calculate the total number of occurrences (`count`), the total sum of indices (`sum_indices`), and the cumulative sum of distances using the following:
     - For each index `i` in the list of indices:
       - The contribution to the distance from all previous indices can be computed as:
         - `i * count_previous - sum_previous`, where `count_previous` is the number of previous indices and `sum_previous` is the sum of those indices.
       - The contribution to the distance from all subsequent indices can be computed as:
         - `sum_next - i * count_next`, where `count_next` is the number of subsequent indices and `sum_next` is the sum of those indices.
   - Maintain running totals for `count` and `sum_indices` as you iterate through the indices to efficiently compute contributions.

3. **Output Construction**: Store the computed distances in the result array corresponding to the original indices.

### Data Structures
- **Dictionary**: To map each unique value to its list of indices.
- **Array**: To store the final results.

### Complexity
- **Time Complexity**: O(n), where n is the length of the `nums` array. Each element is processed a constant number of times, and the operations involving summation and counting are linear.
- **Space Complexity**: O(n) in the worst case, for storing the indices of each unique value.

By following this approach, we efficiently compute the required distances while adhering to the constraints provided in the problem statement.
