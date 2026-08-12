# Length of Longest Subarray With at Most K Frequency (Medium)

**Problem ID:** 2958  
**Date:** 2026-08-12  
**Link:** https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/

## Approach

To solve the problem of finding the length of the longest subarray with at most \( k \) frequency for each element, we can utilize the sliding window technique combined with a hashmap (or dictionary) to efficiently track the frequency of elements within the current window.

### Approach:

1. **Sliding Window Technique**: We maintain a window defined by two pointers, `left` and `right`, which represent the current subarray. The `right` pointer expands the window by iterating through the array, while the `left` pointer contracts the window when the frequency constraint is violated.

2. **Frequency Tracking**: Use a hashmap to count the frequency of each element within the current window. This allows us to quickly check if any element exceeds the allowed frequency \( k \).

3. **Window Expansion**: As we move the `right` pointer to include more elements in the window:
   - Increment the count of the current element in the hashmap.
   - If any element's frequency exceeds \( k \), we need to adjust the `left` pointer to shrink the window from the left until all elements satisfy the frequency condition.

4. **Updating Maximum Length**: Throughout the process, we keep track of the maximum length of valid subarrays found. Whenever the window is valid (i.e., all frequencies are \( \leq k \)), we calculate its length and update the maximum if this length is greater.

### Data Structures:
- **Hashmap**: To store the frequency of each element in the current window.
- **Two Pointers**: `left` and `right` to represent the current subarray.

### Complexity:
- **Time Complexity**: \( O(n) \), where \( n \) is the length of the input array. Each element is processed at most twice (once by the `right` pointer and once by the `left` pointer).
- **Space Complexity**: \( O(m) \), where \( m \) is the number of unique elements in the array, as we store their frequencies in the hashmap.

This efficient approach allows us to find the longest good subarray without the need for nested loops, making it suitable for the input size constraints provided in the problem.
