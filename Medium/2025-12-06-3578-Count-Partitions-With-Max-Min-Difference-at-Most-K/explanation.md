# Count Partitions With Max-Min Difference at Most K (Medium)

**Problem ID:** 3578  
**Date:** 2025-12-06  
**Link:** https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k/

## Approach

To solve the problem of counting partitions of the array `nums` such that the difference between the maximum and minimum elements in each segment is at most `k`, we can utilize a dynamic programming approach combined with a two-pointer technique.

### Main Idea:
The primary idea is to maintain a dynamic programming array `dp` where `dp[i]` represents the number of valid ways to partition the subarray `nums[0:i]`. The challenge is to efficiently determine the valid segments that can be formed with the constraint on the max-min difference.

### Steps:
1. **Initialization**: Start with `dp[0] = 1`, indicating that there is one way to partition an empty array. 

2. **Two-Pointer Technique**: Use two pointers, `start` and `end`, to define the current segment of the array being considered. 
   - The `end` pointer iterates through the array, representing the end of the current segment.
   - The `start` pointer moves to ensure that the maximum and minimum values in the segment `nums[start:end]` satisfy the condition `max - min <= k`.

3. **Maintaining Max and Min**: To efficiently find the maximum and minimum values in the current segment, we can use a data structure like a deque or maintain sorted arrays. This will allow us to quickly check if the current segment is valid as `end` moves.

4. **Updating DP Array**: For each position `end`, if the segment from `start` to `end` is valid, update `dp[end + 1]` by adding `dp[start]`. This means that all partitions ending at `start` can be extended by the new valid segment ending at `end`.

5. **Final Count**: The result will be the sum of all `dp[i]` values, which gives the total number of valid partitions.

### Data Structures:
- An array `dp` to store the number of valid partitions up to each index.
- A deque or sorted list to maintain the current maximum and minimum values efficiently.

### Complexity:
- **Time Complexity**: The overall time complexity is O(n), where n is the length of `nums`, since each element is processed at most twice (once by the `end` pointer and once by the `start` pointer).
- **Space Complexity**: O(n) for the `dp` array, and O(n) for the auxiliary data structure used to maintain max/min values.

This approach ensures that we efficiently count the valid partitions while adhering to the constraints provided in the problem statement.
