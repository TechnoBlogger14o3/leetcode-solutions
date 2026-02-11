# Longest Balanced Subarray II (Hard)

**Problem ID:** 3721  
**Date:** 2026-02-11  
**Link:** https://leetcode.com/problems/longest-balanced-subarray-ii/

## Approach

To solve the problem of finding the longest balanced subarray where the count of distinct even numbers equals the count of distinct odd numbers, we can utilize an efficient sliding window approach combined with hash maps to keep track of distinct counts.

### Main Idea:
The core idea is to maintain a sliding window that expands and contracts to find subarrays where the number of distinct even and odd integers are equal. As we iterate through the array, we will dynamically update the counts of distinct even and odd numbers within the current window.

### Approach:
1. **Initialize Variables**: Use two hash maps (or dictionaries) to count the occurrences of distinct even and odd numbers. Additionally, maintain two counters: one for the count of distinct even numbers and another for distinct odd numbers.

2. **Sliding Window Technique**:
   - Use two pointers, `start` and `end`, to represent the current window in the array.
   - Expand the `end` pointer to include new elements in the window. For each new element:
     - Check if it is even or odd and update the respective hash map and distinct count.
   - If at any point the count of distinct evens equals the count of distinct odds, update the maximum length of the balanced subarray found.
   - If the counts are not equal, increment the `start` pointer to reduce the window size from the left until the counts are equal again or the window is empty.

3. **Complexity**:
   - **Time Complexity**: O(n), where n is the length of the input array. Each element is processed at most twice (once when added and once when removed).
   - **Space Complexity**: O(k), where k is the number of distinct even and odd numbers in the array, which in the worst case can be O(n) if all numbers are distinct.

### Summary:
By leveraging the sliding window technique and using hash maps to track distinct counts efficiently, we can find the longest balanced subarray in linear time. This approach ensures that we handle the constraints effectively, making it suitable for the input limits provided.
