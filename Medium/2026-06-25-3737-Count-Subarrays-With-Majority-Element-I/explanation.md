# Count Subarrays With Majority Element I (Medium)

**Problem ID:** 3737  
**Date:** 2026-06-25  
**Link:** https://leetcode.com/problems/count-subarrays-with-majority-element-i/

## Approach

To solve the problem of counting subarrays with a specified majority element, we can follow a systematic approach that utilizes a sliding window technique combined with prefix sums.

### Main Idea:
The core idea is to identify all valid subarrays where the target element appears more than half the time. For any subarray defined by its start and end indices, the target must appear more than half of the total elements in that subarray. We can leverage the properties of prefix sums to efficiently calculate the counts of the target element in various subarrays.

### Steps:
1. **Count Occurrences**: First, iterate through the array to count the total occurrences of the target element. If the target does not exist in the array, return 0 immediately.

2. **Sliding Window**: Use two pointers (or a sliding window) to explore all possible subarrays. The left pointer (`l`) will denote the start of the subarray, while the right pointer (`r`) will expand to include more elements.

3. **Track Counts**: Maintain a count of the target elements within the current window defined by `l` and `r`. For each position of `r`, check if the count of the target exceeds half the size of the current window.

4. **Count Valid Subarrays**: If the count of the target exceeds half, all subarrays starting from `l` to `r` are valid. To count these, note that if the current window size is `n`, there are `n - r + 1` valid subarrays starting from `l`.

5. **Adjust Left Pointer**: If the count does not satisfy the majority condition, increment the left pointer `l` to reduce the window size until the condition is met or the window becomes invalid.

6. **Repeat**: Continue this process until all possible subarrays have been evaluated.

### Data Structures:
- An integer variable to keep track of the count of the target element in the current window.
- Two pointers to define the current subarray window.
- A variable to accumulate the total count of valid subarrays.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array. Each element is processed at most twice (once by the right pointer and once by the left pointer).
- **Space Complexity**: O(1), as we are using a constant amount of additional space regardless of the input size.

This approach efficiently counts the desired subarrays by leveraging the properties of the majority element and the sliding window technique, ensuring that we do not redundantly check every possible subarray explicitly.
