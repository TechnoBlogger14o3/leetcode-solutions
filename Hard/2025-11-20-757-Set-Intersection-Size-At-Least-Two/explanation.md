# Set Intersection Size At Least Two (Hard)

**Problem ID:** 757  
**Date:** 2025-11-20  
**Link:** https://leetcode.com/problems/set-intersection-size-at-least-two/

## Approach

To solve the "Set Intersection Size At Least Two" problem, we need to ensure that every interval in the given list has at least two integers from a selected set. The main idea is to strategically choose integers such that the total count of selected integers is minimized while still satisfying the requirement for all intervals.

### Approach:

1. **Sort Intervals**: Start by sorting the intervals based on their ending points. This allows us to handle overlapping intervals more effectively and ensures that we can cover as many intervals as possible with the least number of integers.

2. **Greedy Selection**: Use a greedy approach to select integers. For each interval, check if it is already covered by the previously selected integers. If it is not covered, we need to add integers to ensure that this interval has at least two integers from our set.

3. **Choosing Integers**:
   - If an interval `[start, end]` is not covered, check the last two integers that were added to the set. If both are less than `start`, add the two largest integers from the interval (i.e., `end` and `end-1`).
   - If one of the last two integers is within the interval, add the other integer to ensure that the interval is covered with at least two integers.

4. **Data Structures**: Use a list to maintain the selected integers. A set can also be used to quickly check if an integer is already included in the selected integers.

5. **Complexity**: The overall time complexity is O(n log n) due to sorting the intervals, where n is the number of intervals. The greedy selection process runs in O(n), resulting in an efficient solution.

### Summary:
The solution effectively combines sorting and a greedy selection strategy to ensure that each interval is covered by at least two integers while minimizing the total number of integers selected. By focusing on the end points of intervals and ensuring coverage through careful selection, we achieve the required result efficiently.
