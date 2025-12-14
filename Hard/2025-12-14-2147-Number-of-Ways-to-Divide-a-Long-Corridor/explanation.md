# Number of Ways to Divide a Long Corridor (Hard)

**Problem ID:** 2147  
**Date:** 2025-12-14  
**Link:** https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/

## Approach

To solve the problem of dividing the corridor into sections with exactly two seats ('S') each, we can follow a structured approach:

### Problem Breakdown
1. **Count Seats**: First, we need to count the total number of seats ('S') in the corridor. If this count is odd, it's impossible to divide them into pairs of two, and we should immediately return 0.

2. **Identify Pairs**: If the count of 'S' is even, we can calculate the number of pairs of seats we need to form. Each pair will correspond to a section. The number of pairs is `total_seats / 2`.

3. **Locate Seats**: We will traverse the corridor and record the indices of all the 'S' characters. This will help us in determining how many ways we can place dividers between these pairs.

4. **Count Dividers**: For each pair of seats, we need to check the number of plants ('P') between them. The number of ways to place dividers between two seats is determined by the number of plants between them. If there are `k` plants between two seats, we have `k + 1` options for placing a divider (before the first plant, between plants, and after the last plant).

5. **Calculate Total Ways**: The total number of ways to divide the corridor is the product of the number of ways to place dividers for each pair of seats. Since the result can be large, we will take the modulo \(10^9 + 7\) at each multiplication step.

### Data Structures
- An array or list to store the indices of 'S' characters.
- Simple integer variables to count and compute the number of ways.

### Complexity
- **Time Complexity**: O(n), where n is the length of the corridor string. We traverse the string a couple of times (once to count 'S' and once to collect indices).
- **Space Complexity**: O(k), where k is the number of 'S' characters, to store their indices.

### Summary
The approach involves counting the seats, determining the number of pairs, and calculating the ways to place dividers based on the plants between each pair of seats. This systematic method ensures that we efficiently find the answer while adhering to the constraints provided.
