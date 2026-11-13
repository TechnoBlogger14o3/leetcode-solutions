# Count Non-Decreasing Subarrays After K Operations (Hard)

**Problem ID:** 3420  
**Date:** 2026-11-13  
**Link:** https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/

## Approach

To solve the problem of counting non-decreasing subarrays after performing at most `k` increment operations, we can utilize a two-pointer (or sliding window) technique combined with a greedy approach.

### Main Idea:
The primary goal is to identify subarrays that can be transformed into non-decreasing order with the allowed number of operations. We need to calculate how many operations are required to ensure that each element in a subarray is at least as large as the previous element. If the required operations exceed `k`, we cannot make that subarray non-decreasing.

### Approach:
1. **Two Pointers (Sliding Window):** Use two pointers (`left` and `right`) to define the current subarray. The `right` pointer expands the window by including new elements, while the `left` pointer contracts the window when the number of operations needed exceeds `k`.

2. **Operations Calculation:** For each new element added to the subarray (i.e., when moving `right`), calculate the operations needed to make the current subarray non-decreasing:
   - If `nums[right] < nums[right - 1]`, compute the difference and add it to a running total of operations needed.
   - If the total operations exceed `k`, increment the `left` pointer to reduce the size of the subarray until the operations needed are within the limit.

3. **Counting Valid Subarrays:** For each position of the `right` pointer, if the operations needed are within `k`, all subarrays ending at `right` and starting from any position between `left` and `right` are valid. The count of such subarrays can be calculated as `right - left + 1`.

### Data Structures:
- Two pointers (`left` and `right`) to manage the current subarray.
- A variable to keep track of the total operations needed.

### Complexity:
- **Time Complexity:** O(n), where n is the length of the array. Each element is processed at most twice (once by `right` and once by `left`).
- **Space Complexity:** O(1) since we are using a constant amount of space for pointers and counters.

This approach efficiently counts the number of valid non-decreasing subarrays by leveraging the properties of sliding windows and greedy operations, ensuring that we stay within the constraints provided by the problem.
