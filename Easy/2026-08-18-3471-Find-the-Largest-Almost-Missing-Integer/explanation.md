# Find the Largest Almost Missing Integer (Easy)

**Problem ID:** 3471  
**Date:** 2026-08-18  
**Link:** https://leetcode.com/problems/find-the-largest-almost-missing-integer/

## Approach

To solve the problem of finding the largest almost missing integer from the given array `nums`, we can follow a systematic approach:

### Approach:

1. **Sliding Window Technique**: 
   - We will utilize a sliding window of size `k` to traverse through the array `nums`. This allows us to efficiently count the occurrences of each integer within each subarray of size `k`.

2. **Counting Occurrences**:
   - We will maintain a frequency dictionary (`occurrences`) to count how many times each integer appears across all subarrays of size `k`. 
   - As we slide the window from the start to the end of the array, we will update the counts by adding the new element entering the window and removing the element that is leaving the window.

3. **Identifying Almost Missing Integers**:
   - After processing all subarrays, we will iterate through the `occurrences` dictionary to identify integers that appear exactly once.

4. **Finding the Largest Integer**:
   - Among the integers that are identified as almost missing (i.e., those that appear exactly once), we will find the maximum value. If no such integer exists, we will return `-1`.

### Data Structures:
- A dictionary (or hashmap) to keep track of the count of each integer's occurrences across the subarrays.

### Complexity:
- **Time Complexity**: O(n), where `n` is the length of `nums`. This is because we traverse the array once to count occurrences and then perform a constant-time operation to find the maximum among the integers that appear once.
- **Space Complexity**: O(m), where `m` is the number of unique integers in `nums`. Given the constraints (0 to 50), this is manageable.

By following this approach, we ensure an efficient solution to the problem while adhering to the constraints provided.
