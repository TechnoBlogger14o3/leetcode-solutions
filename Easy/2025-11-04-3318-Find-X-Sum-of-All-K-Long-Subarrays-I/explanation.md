# Find X-Sum of All K-Long Subarrays I (Easy)

**Problem ID:** 3318  
**Date:** 2025-11-04  
**Link:** https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/

## Approach

To solve the problem of finding the x-sum of all k-long subarrays, we can follow a systematic approach utilizing a sliding window technique combined with frequency counting.

### Main Idea:
1. **Sliding Window**: We will iterate through the array using a sliding window of size `k`. This allows us to efficiently compute the x-sum for each subarray without recalculating from scratch for overlapping elements.
  
2. **Frequency Counting**: For each subarray, we need to count the occurrences of each element. We can use a dictionary (or a fixed-size array since the values are bounded between 1 and 50) to keep track of the frequency of elements within the current window.

3. **Top x Elements**: After counting the frequencies, we need to determine the top `x` most frequent elements. In case of ties (same frequency), we will prioritize the larger values. This can be efficiently handled by sorting the frequency dictionary based on counts and values.

4. **Sum Calculation**: Once we have the top `x` elements, we compute their sum, which gives us the x-sum for the current subarray.

5. **Updating the Window**: As we slide the window to the right, we will update the frequency count by removing the element that is sliding out of the window and adding the new element that is sliding into the window.

### Data Structures:
- A frequency dictionary (or a list) to count occurrences of elements in the current window.
- A list to store the result of x-sums for each subarray.

### Complexity:
- **Time Complexity**: The overall time complexity is O(n * (k + m log m)), where `n` is the length of the array, `k` is the size of the subarray, and `m` is the number of distinct elements in the current window (which is at most 50). The sorting step for the top `x` elements contributes to the log factor.
- **Space Complexity**: O(1) for the frequency array (since values are bounded), and O(n) for the result array.

This approach is efficient given the constraints, allowing us to compute the required x-sums for all subarrays in a manageable time frame.
