# Avoid Flood in The City (Medium)

**Problem ID:** 1488  
**Date:** 2025-10-07  
**Link:** https://leetcode.com/problems/avoid-flood-in-the-city/

## Approach

To solve the "Avoid Flood in The City" problem, we can use a greedy approach combined with a hash set to keep track of the lakes that are currently full. The main idea is to process each day's rain and manage the drying of lakes effectively to avoid floods.

### Approach:

1. **Initialization**:
   - Create an array `ans` of the same length as `rains`, initialized with `-1` to indicate days when it rains.
   - Use a hash set `fullLakes` to track which lakes are currently full.
   - Use a list `dryDays` to record the indices of days when no rain occurs (i.e., `rains[i] == 0`).

2. **Processing Rain Days**:
   - Iterate through the `rains` array:
     - If `rains[i] > 0` (it rains on lake `rains[i]`):
       - Check if the lake is already in `fullLakes`. If it is, it means a flood will occur, and we should return an empty array.
       - Otherwise, add the lake to `fullLakes` and set `ans[i]` to `-1` (indicating rain on this day).
     - If `rains[i] == 0` (no rain):
       - If there are full lakes (i.e., `fullLakes` is not empty), we can choose one lake to dry. We can pick any lake from `fullLakes`, remove it from `fullLakes`, and record the dried lake in `ans[i]`.
       - If there are no full lakes, we can choose not to dry any lake, and `ans[i]` remains `-1`.

3. **Final Output**:
   - After processing all days, the `ans` array will contain the required output. If we encountered a situation where a flood was unavoidable, we would have returned an empty array earlier.

### Data Structures:
- **Array**: To store the results for each day.
- **Hash Set**: To track full lakes efficiently, allowing O(1) average time complexity for insertions and lookups.
- **List**: To keep track of dry days, although it is not strictly necessary for the solution.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the `rains` array. We make a single pass through the array and perform constant-time operations for each element.
- **Space Complexity**: O(m), where m is the number of unique lakes that have been filled. In the worst case, this can be up to O(n) if all lakes are unique.

This approach efficiently manages the constraints of the problem while ensuring that floods are avoided wherever possible.
