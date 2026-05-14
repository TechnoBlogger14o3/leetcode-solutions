# Check if Array is Good (Easy)

**Problem ID:** 2784  
**Date:** 2026-05-14  
**Link:** https://leetcode.com/problems/check-if-array-is-good/

## Approach

To solve the problem of checking if the given array `nums` is a "good" array (i.e., a permutation of `base[n]`), we can follow a systematic approach:

### Main Idea:
1. **Identify the Maximum Element**: The first step is to determine the maximum element in the array `nums`, which we denote as `n`. This is crucial because `base[n]` is defined in terms of this maximum value.

2. **Check Length Consistency**: The length of `base[n]` is `n + 1`, as it contains the integers from `1` to `n` (which are `n` elements) and an additional occurrence of `n`. Therefore, we need to ensure that the length of `nums` matches `n + 1`. If it does not, we can immediately return `false`.

3. **Count Occurrences**: If the length is valid, we then need to verify that the numbers in `nums` match the expected counts in `base[n]`. Specifically:
   - There should be exactly one occurrence of each integer from `1` to `n - 1`.
   - There should be exactly two occurrences of `n`.

4. **Use a Frequency Map**: A frequency map (or dictionary) can be employed to count occurrences of each number in `nums`. After populating this map, we can check the counts against the expected values.

### Data Structures:
- **Frequency Map**: A dictionary or hashmap to store the count of each integer in `nums`.

### Complexity:
- **Time Complexity**: O(m), where `m` is the length of the array `nums` (up to 100). This is efficient since we only need to traverse the array a couple of times (once to create the frequency map and once to validate counts).
- **Space Complexity**: O(n), where `n` is the maximum value in `nums` (up to 200). This accounts for the space used by the frequency map.

By following this approach, we can efficiently determine whether `nums` is a permutation of `base[n]` based on the defined criteria.
