# Number of Smooth Descent Periods of a Stock (Medium)

**Problem ID:** 2110  
**Date:** 2025-12-15  
**Link:** https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/

## Approach

To solve the problem of counting the number of smooth descent periods in a stock price history, we can utilize a straightforward approach that leverages a single pass through the array of prices.

### Main Idea:
The key observation is that a smooth descent period consists of contiguous days where each day’s price is exactly 1 less than the previous day’s price. We can keep track of these periods by maintaining a count of how many consecutive days form a smooth descent.

### Approach:
1. **Initialization**: Start by initializing a variable to store the total count of smooth descent periods (`total_periods`) and another variable to keep track of the current length of a smooth descent period (`current_length`).

2. **Iterate through the prices**: Loop through the `prices` array starting from the second element:
   - If the current price is exactly 1 less than the previous price, it indicates that we are in a smooth descent. In this case, increment the `current_length` by 1.
   - If the condition is not satisfied (i.e., the current price is not 1 less than the previous price), reset `current_length` to 0 since the smooth descent has ended.

3. **Count periods**: For each day, whether it starts a new descent or continues an existing one, add the count of smooth descent periods to `total_periods`. Each single day is also considered a valid smooth descent period, so we can add `current_length + 1` to the total periods at each step.

4. **Final Count**: After iterating through the entire array, the `total_periods` will contain the total count of all smooth descent periods.

### Data Structures:
- We primarily use simple integer variables for counting (`total_periods` and `current_length`), which makes the space complexity O(1).

### Complexity:
- **Time Complexity**: O(n), where n is the length of the `prices` array, since we are making a single pass through the array.
- **Space Complexity**: O(1), as we are using a constant amount of extra space.

This efficient approach ensures that we can handle the upper constraint of the problem (up to 100,000 prices) comfortably within time limits.
