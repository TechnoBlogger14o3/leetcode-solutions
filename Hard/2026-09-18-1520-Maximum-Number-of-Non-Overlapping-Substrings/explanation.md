# Maximum Number of Non-Overlapping Substrings (Hard)

**Problem ID:** 1520  
**Date:** 2026-09-18  
**Link:** https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/

## Approach

To solve the problem of finding the maximum number of non-overlapping substrings in a given string `s`, we can follow a systematic approach leveraging the concept of character intervals and greedy selection.

### Approach:

1. **Character Interval Calculation**:
   - First, we need to determine the intervals for each character in the string. For each character, identify the first and last occurrence in the string. This gives us a range for each character that must be included in any substring that contains that character.

2. **Merging Intervals**:
   - Once we have the intervals for each character, we need to merge overlapping intervals. This is crucial because if one interval overlaps with another, we cannot select them both as non-overlapping substrings.
   - To do this, sort the intervals by their starting index. Iterate through the sorted list and merge intervals that overlap. An interval `[start1, end1]` overlaps with `[start2, end2]` if `start2 <= end1`.

3. **Greedy Selection**:
   - After merging, we will have a list of non-overlapping intervals. The next step is to select the maximum number of these intervals while ensuring they do not overlap.
   - We can use a greedy strategy: iterate through the merged intervals, and for each interval, select it if it starts after the last selected interval ends. This ensures that we maximize the number of selected intervals.

4. **Minimizing Total Length**:
   - If there are multiple ways to select the same number of intervals, we need to choose the combination that has the minimum total length. This can be achieved by keeping track of the lengths of the selected intervals and choosing the combination with the least total length.

### Data Structures:
- Use a list to store the intervals for each character.
- A list to hold merged intervals.
- A final list to store the selected non-overlapping substrings.

### Complexity:
- **Time Complexity**: The overall time complexity is O(n), where n is the length of the string. This includes the time to find character intervals (O(n)), merge intervals (O(n log n) due to sorting), and select intervals (O(n)).
- **Space Complexity**: O(n) for storing the intervals.

This approach ensures that we efficiently find the maximum number of non-overlapping substrings while adhering to the constraints of including all occurrences of any character within those substrings.
