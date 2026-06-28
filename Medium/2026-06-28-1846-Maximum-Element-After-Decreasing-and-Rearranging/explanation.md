# Maximum Element After Decreasing and Rearranging (Medium)

**Problem ID:** 1846  
**Date:** 2026-06-28  
**Link:** https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/

## Approach

To solve the problem of finding the maximum element after rearranging and decreasing elements of the array while satisfying specific conditions, we can follow a systematic approach:

### Main Idea:
The goal is to rearrange the elements of the array such that:
1. The first element is `1`.
2. The absolute difference between any two adjacent elements is at most `1`.

Given these constraints, we can derive the maximum possible value of any element in the modified array.

### Approach:
1. **Sort the Array**: Start by sorting the input array. This helps in easily managing the differences between adjacent elements and ensures that we can work with the smallest values first.

2. **Initialize the First Element**: Set the first element to `1`, as required by the problem statement.

3. **Iterate Through the Sorted Array**: For each subsequent element in the sorted array, we need to ensure that it can be adjusted to either its original value or one more than the previous element (to maintain the condition of adjacent differences being at most `1`):
   - For each element, if the current value is greater than the previous value plus one, we can only set it to `previous + 1`.
   - If the current value is less than or equal to `previous + 1`, we can keep it as is.

4. **Track the Maximum Value**: During the iteration, maintain a variable to track the maximum value encountered after adjustments.

### Data Structures:
- A simple array (or list) for the input.
- An integer variable to keep track of the previous value and another for the maximum value.

### Complexity:
- **Time Complexity**: The dominant factor is the sorting step, which is `O(n log n)`, where `n` is the length of the array. The subsequent iteration through the array is `O(n)`, resulting in an overall time complexity of `O(n log n)`.
- **Space Complexity**: The space complexity is `O(1)` if we consider only the input and a few auxiliary variables, as we are modifying the array in place.

### Conclusion:
By sorting the array and iterating through it while adjusting values based on the defined conditions, we can efficiently determine the maximum possible value of any element in the modified array that meets the problem's requirements.
