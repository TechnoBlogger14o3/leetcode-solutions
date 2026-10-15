# Subarrays Distinct Element Sum of Squares I (Easy)

**Problem ID:** 2913  
**Date:** 2026-10-15  
**Link:** https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/

## Approach

To solve the problem of calculating the sum of the squares of distinct counts of all subarrays in the given integer array `nums`, we can follow a systematic approach using a sliding window technique combined with a frequency map.

### Main Idea:
The key idea is to efficiently count the distinct elements in all possible subarrays and compute the sum of the squares of these counts. Instead of generating all subarrays explicitly, we can utilize a sliding window approach to dynamically maintain the count of distinct elements as we expand or contract our window.

### Approach:
1. **Sliding Window**: Use two pointers (`start` and `end`) to represent the current subarray. The `end` pointer expands the window by including new elements, while the `start` pointer contracts the window when necessary.
  
2. **Frequency Map**: Maintain a frequency map (or dictionary) to count occurrences of each element in the current window. This helps in determining when an element becomes distinct or ceases to be distinct.

3. **Distinct Count Calculation**: 
   - When the `end` pointer moves to include a new element, check if it is already in the frequency map:
     - If it is not present, it means we have a new distinct element, and we increase our distinct count.
     - If it is present, we simply update its count.
   - After updating the frequency map, compute the square of the current distinct count and add it to a running total.

4. **Iterate Through All Subarrays**: 
   - For each position of `start`, iterate `end` from `start` to the end of the array, adjusting the frequency map and distinct count accordingly.
   - After processing each subarray defined by `start` and `end`, move `start` one step forward and repeat until all starting positions are covered.

### Data Structures:
- **Frequency Map**: A dictionary to keep track of the count of each element in the current subarray.
- **Variables**: Integers to maintain the current distinct count and the total sum of squares.

### Complexity:
- **Time Complexity**: The overall time complexity is O(n^2) in the worst case, where `n` is the length of `nums`. This is because for each starting index, we may need to scan through the array to find all subarrays.
- **Space Complexity**: O(k), where `k` is the number of distinct elements in `nums`, which is at most 100 due to the problem constraints.

This approach efficiently calculates the required sum without the need to explicitly generate each subarray, leveraging the properties of sliding windows and frequency counting.
