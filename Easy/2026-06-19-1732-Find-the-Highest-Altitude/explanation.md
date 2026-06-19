# Find the Highest Altitude (Easy)

**Problem ID:** 1732  
**Date:** 2026-06-19  
**Link:** https://leetcode.com/problems/find-the-highest-altitude/

## Approach

To solve the problem of finding the highest altitude during the biker's trip, we can adopt a straightforward approach that involves iterating through the given `gain` array while maintaining a running total of the current altitude.

### Approach:

1. **Initialization**: Start with an initial altitude of `0` at point `0`. Initialize a variable to keep track of the highest altitude encountered, also starting at `0`.

2. **Iterate Through Gains**: Loop through each element in the `gain` array. For each gain value:
   - Update the current altitude by adding the current gain to it.
   - After updating, check if the current altitude exceeds the highest altitude recorded so far. If it does, update the highest altitude.

3. **Return Result**: After processing all gain values, return the highest altitude recorded.

### Key Points:

- **Data Structures**: We only need a few integer variables to keep track of the current altitude and the highest altitude, making this approach very space-efficient.

- **Time Complexity**: The solution runs in O(n) time, where n is the length of the `gain` array, since we make a single pass through the array.

- **Space Complexity**: The space complexity is O(1) because we are using a constant amount of additional space regardless of the input size.

This approach efficiently computes the highest altitude by leveraging a simple loop and basic arithmetic operations, ensuring clarity and optimal performance within the problem's constraints.
