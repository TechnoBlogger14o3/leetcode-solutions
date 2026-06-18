# Angle Between Hands of a Clock (Medium)

**Problem ID:** 1344  
**Date:** 2026-06-18  
**Link:** https://leetcode.com/problems/angle-between-hands-of-a-clock/

## Approach

To solve the problem of finding the angle between the hour and minute hands of a clock, we can break down the approach into a few clear steps:

### Main Idea:
1. **Calculate the Position of the Minute Hand**: The minute hand moves 360 degrees in 60 minutes, which means it moves 6 degrees per minute. Therefore, the angle of the minute hand from the 12 o'clock position can be calculated as:
   \[
   \text{minute\_angle} = \text{minutes} \times 6
   \]

2. **Calculate the Position of the Hour Hand**: The hour hand moves 360 degrees in 12 hours, which means it moves 30 degrees per hour. Additionally, it moves as the minutes progress, specifically 0.5 degrees per minute (since it moves 30 degrees in 60 minutes). The angle of the hour hand can be calculated as:
   \[
   \text{hour\_angle} = (\text{hour} \% 12) \times 30 + \text{minutes} \times 0.5
   \]
   Here, we use `hour % 12` to handle the case where the hour is 12, as it should be treated as 0.

3. **Calculate the Absolute Difference**: To find the angle between the two hands, compute the absolute difference between the two angles:
   \[
   \text{angle} = |\text{hour\_angle} - \text{minute\_angle}|
   \]

4. **Determine the Smaller Angle**: Since the maximum angle between two hands can be 360 degrees, the smaller angle will be:
   \[
   \text{smaller\_angle} = \min(\text{angle}, 360 - \text{angle})
   \]

### Data Structures:
No complex data structures are required for this problem. We primarily utilize basic arithmetic operations and variables to store angles.

### Complexity:
- **Time Complexity**: O(1) - The solution involves a constant number of arithmetic operations regardless of input size.
- **Space Complexity**: O(1) - We only use a fixed amount of space for storing intermediate angle values.

This approach ensures that we accurately compute the angle between the clock hands while adhering to the constraints provided in the problem statement.
