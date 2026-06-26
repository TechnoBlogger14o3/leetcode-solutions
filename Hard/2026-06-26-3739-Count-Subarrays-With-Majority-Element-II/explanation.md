# Count Subarrays With Majority Element II (Hard)

**Problem ID:** 3739  
**Date:** 2026-06-26  
**Link:** https://leetcode.com/problems/count-subarrays-with-majority-element-ii/

## Approach

To solve the problem of counting subarrays with a given target as the majority element, we can adopt a systematic approach that leverages the properties of majority elements and efficient counting techniques.

### Main Idea:
The core idea is to identify all valid subarrays where the target appears more than half the time. A majority element in a subarray of length `k` must appear at least `(k // 2) + 1` times. Thus, we can utilize a two-pointer technique or a sliding window approach to efficiently count the occurrences of the target in the subarrays.

### Approach:
1. **Initial Check**: First, check if the target exists in the array. If not, return 0 immediately since no subarray can have the target as a majority.

2. **Counting Occurrences**: Iterate through the array while maintaining a count of the target's occurrences. Use a variable to track the number of valid subarrays that can be formed with the current segment of the array where the target is present.

3. **Sliding Window Technique**:
   - Use two pointers (`left` and `right`) to define the current window of consideration.
   - Expand the `right` pointer to include more elements until the count of the target exceeds half of the current window size.
   - When the count of the target is sufficient (i.e., greater than half), calculate the number of valid subarrays that can be formed with the current `right` position.
   - Move the `left` pointer to shrink the window and check for new valid subarrays.

4. **Count Valid Subarrays**: For each valid window where the target is the majority, compute the number of subarrays that can be formed by considering the position of the `left` pointer. Specifically, if the current window size is `k`, then the number of valid subarrays is determined by the distance between the `left` pointer and the current position of `right`.

### Data Structures:
- A simple integer counter to track the occurrences of the target.
- Two pointers (or indices) to manage the current window of the subarray.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array. Each element is processed at most twice (once by the `right` pointer and once by the `left` pointer).
- **Space Complexity**: O(1), as we are using a constant amount of extra space for counters and pointers.

This approach efficiently counts the desired subarrays while ensuring that we adhere to the constraints of the problem, making it suitable for large input sizes.
