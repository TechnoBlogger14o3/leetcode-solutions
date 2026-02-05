# Transformed Array (Easy)

**Problem ID:** 3379  
**Date:** 2026-02-05  
**Link:** https://leetcode.com/problems/transformed-array/

## Approach

To solve the "Transformed Array" problem, we need to create a new array `result` based on the movements dictated by the values in the input array `nums`. The approach can be broken down into the following steps:

### Approach:

1. **Initialization**: Create a new array `result` of the same size as `nums` to store the final output.

2. **Iterate through the array**: Loop through each index `i` of `nums`:
   - If `nums[i] > 0`: Calculate the new index by moving `nums[i]` steps to the right. Since the array is circular, use the modulo operation to ensure the index wraps around: `new_index = (i + nums[i]) % n`, where `n` is the length of `nums`.
   - If `nums[i] < 0`: Calculate the new index by moving `abs(nums[i])` steps to the left. Again, use modulo to handle wrapping: `new_index = (i + nums[i] + n) % n`.
   - If `nums[i] == 0`: Simply set `result[i]` to `0`.

3. **Store the results**: For each computed `new_index`, assign the value of `nums[new_index]` to `result[i]`.

4. **Return the result**: After processing all indices, return the `result` array.

### Data Structures:
- We use a simple array `result` to store the transformed values, which is straightforward given the constraints.

### Complexity Analysis:
- **Time Complexity**: O(n), where n is the length of the input array `nums`. We perform a single pass through the array, and each index computation is done in constant time.
- **Space Complexity**: O(n) for the `result` array.

### Summary:
The main idea is to leverage modular arithmetic to handle the circular nature of the array while iterating through each element to determine the new positions based on the values in `nums`. This approach is efficient and straightforward, given the constraints of the problem.
