# Longest Balanced Subarray I (Medium)

**Problem ID:** 3719  
**Date:** 2026-02-10  
**Link:** https://leetcode.com/problems/longest-balanced-subarray-i/

## Approach

To solve the problem of finding the longest balanced subarray, we can use a sliding window approach combined with hash maps to efficiently track the distinct even and odd numbers within the current subarray.

### Main Idea:
The goal is to maintain a window (subarray) where the count of distinct even numbers equals the count of distinct odd numbers. We will expand the window by moving the right pointer and contract it by moving the left pointer when the counts become unequal.

### Approach:
1. **Two Pointers (Sliding Window)**: Use two pointers, `left` and `right`, to represent the current subarray. Start both pointers at the beginning of the array.

2. **Hash Maps for Counting**: Utilize two hash maps (or dictionaries):
   - One for counting distinct even numbers.
   - Another for counting distinct odd numbers.

3. **Iterate with Right Pointer**: Incrementally move the `right` pointer to include new elements into the current window. Update the corresponding hash map based on whether the current number is even or odd.

4. **Check Balance**: After adding a new number, check if the counts of distinct even and odd numbers are equal:
   - If they are equal, update the maximum length of the balanced subarray found so far.
   - If they are not equal, increment the `left` pointer to shrink the window from the left until the counts are equal again.

5. **Continue Until End of Array**: Repeat the above steps until the `right` pointer has traversed the entire array.

### Data Structures:
- Two hash maps (or dictionaries) for counting distinct even and odd numbers.
- Two pointers to maintain the sliding window.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array. Each element is processed at most twice (once by the right pointer and once by the left pointer).
- **Space Complexity**: O(n) in the worst case for the hash maps storing distinct even and odd numbers.

This approach efficiently finds the longest balanced subarray by dynamically adjusting the window size while keeping track of the necessary counts, ensuring that we meet the problem's constraints effectively.
