# Maximum Total Subarray Value II (Hard)

**Problem ID:** 3691  
**Date:** 2026-06-10  
**Link:** https://leetcode.com/problems/maximum-total-subarray-value-ii/

## Approach

To solve the problem of finding the maximum total subarray value with the given constraints, we can break down the approach into several key steps:

### Main Idea:
The goal is to select exactly `k` distinct non-empty subarrays from the input array `nums`, such that the sum of their values (defined as the difference between the maximum and minimum elements of each subarray) is maximized. 

### Approach:
1. **Understanding Subarray Values**: The value of a subarray `nums[l..r]` is calculated as `max(nums[l..r]) - min(nums[l..r])`. To maximize the total value, we need to efficiently compute these values for various subarrays.

2. **Precomputation of Maximum and Minimum**: We can utilize data structures like a deque or a segment tree to maintain the maximum and minimum values in a sliding window. This allows us to compute the values of all possible subarrays efficiently.

3. **Dynamic Programming with Priority Queue**: 
   - We can employ a dynamic programming approach where we maintain a priority queue (or max-heap) to keep track of the best `k` subarray values as we iterate through the array.
   - For each starting index `i`, we can expand the subarray to the right and compute its value, pushing it into the priority queue.
   - If the size of the queue exceeds `k`, we pop the smallest element, ensuring we always keep the top `k` maximum values.

4. **Iterate Over All Subarrays**: Iterate over all possible starting indices and for each index, expand to all possible ending indices, calculating the subarray values and updating the priority queue accordingly.

5. **Final Calculation**: After processing all subarrays, the sum of the values in the priority queue will give the maximum total value achievable with exactly `k` distinct subarrays.

### Data Structures:
- **Deque or Segment Tree**: For efficient max/min calculations over subarrays.
- **Priority Queue (Max-Heap)**: To maintain the top `k` maximum values efficiently.

### Complexity:
- The time complexity is approximately `O(n^2 log k)` in the worst case due to the nested iteration over subarrays and the logarithmic time complexity for maintaining the priority queue.
- The space complexity is `O(k)` for storing the top `k` values in the priority queue.

This approach effectively balances the need to compute subarray values efficiently while ensuring we can select the optimal `k` subarrays to maximize the total value.
