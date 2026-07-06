# Remove Covered Intervals (Medium)

**Problem ID:** 1288  
**Date:** 2026-07-06  
**Link:** https://leetcode.com/problems/remove-covered-intervals/

## Approach

To solve the "Remove Covered Intervals" problem, we can use a sorting and linear traversal approach. The main idea is to leverage the properties of intervals to efficiently determine which intervals are covered by others.

### Approach:

1. **Sorting**: First, we sort the intervals based on their starting point (`l`). If two intervals have the same starting point, we sort them by their ending point (`r`) in descending order. This ensures that when we iterate through the list, if an interval starts at the same point as another but ends earlier, it will come first in the sorted list.

2. **Linear Traversal**: After sorting, we initialize a variable to keep track of the end of the last added interval (`last_end`). We also maintain a count of remaining intervals. We iterate through the sorted list of intervals:
   - For each interval, we check if its end (`r`) is less than or equal to `last_end`. If it is, this interval is covered by the last added interval, and we skip it.
   - If it is not covered, we increment the count of remaining intervals and update `last_end` to the current interval's end.

3. **Counting Remaining Intervals**: By the end of the traversal, the count will represent the number of intervals that are not covered by any other interval.

### Data Structures:
- An array to hold the intervals.
- Variables to keep track of the count of remaining intervals and the last end point.

### Complexity:
- **Time Complexity**: The sorting step takes \(O(n \log n)\), and the linear traversal takes \(O(n)\), where \(n\) is the number of intervals. Thus, the overall time complexity is \(O(n \log n)\).
- **Space Complexity**: The space complexity is \(O(1)\) if we disregard the input storage, as we only use a few additional variables.

This approach efficiently identifies and counts the non-covered intervals, ensuring that we handle the problem within the constraints provided.
