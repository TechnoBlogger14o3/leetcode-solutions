# Maximum Ice Cream Bars (Medium)

**Problem ID:** 1833  
**Date:** 2026-06-21  
**Link:** https://leetcode.com/problems/maximum-ice-cream-bars/

## Approach

To solve the "Maximum Ice Cream Bars" problem using a counting sort approach, we can follow these steps:

### Main Idea:
The goal is to maximize the number of ice cream bars the boy can buy without exceeding his available coins. Since the costs of the ice cream bars are bounded (from 1 to 100,000), we can utilize counting sort to efficiently determine how many bars he can afford.

### Approach:
1. **Counting Sort Preparation**:
   - Create a frequency array `count` of size `max_cost + 1` (where `max_cost` is the maximum possible cost of an ice cream bar, 100,000). This array will store how many ice cream bars are available at each cost.

2. **Populate the Frequency Array**:
   - Iterate through the `costs` array and increment the corresponding index in the `count` array. This allows us to know how many ice cream bars are available at each price.

3. **Calculate Maximum Purchasable Bars**:
   - Initialize a variable `total_bars` to keep track of the number of ice cream bars bought and a variable `total_cost` to track the total cost incurred.
   - Iterate through the `count` array starting from the lowest cost (1) to the highest cost (up to `max_cost`):
     - For each cost, check how many bars are available (`count[cost]`).
     - Calculate the maximum number of bars that can be bought at that cost without exceeding the available coins.
     - Update `total_bars` and `total_cost` accordingly.
     - If at any point the `total_cost` exceeds the available coins, break out of the loop.

### Data Structures:
- **Frequency Array**: An array of size 100,001 (to accommodate costs from 1 to 100,000) to count the occurrences of each cost.
- **Variables**: Two integers to track the total number of bars bought and the total cost incurred.

### Complexity:
- **Time Complexity**: O(n + k), where n is the number of ice cream bars and k is the range of costs (which is constant at 100,000). This is efficient given the constraints.
- **Space Complexity**: O(k), where k is the range of costs (100,000), for the frequency array.

This approach efficiently counts and processes the costs to determine the maximum number of ice cream bars that can be purchased within the given budget.
