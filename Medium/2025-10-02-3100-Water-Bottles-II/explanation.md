# Water Bottles II (Medium)

**Problem ID:** 3100  
**Date:** 2025-10-02  
**Link:** https://leetcode.com/problems/water-bottles-ii/

## Approach

To solve the "Water Bottles II" problem, we can use a greedy approach to maximize the number of water bottles consumed through drinking and exchanging empty bottles for full ones.

### Main Idea:
1. **Initial Setup**: Start with the given number of full bottles (`numBottles`) and initialize a counter for the total number of bottles drunk.
2. **Drinking and Exchanging**: In each iteration:
   - Drink all the full bottles available, adding to the total count of bottles drunk.
   - Convert all the full bottles to empty bottles.
   - Check if the number of empty bottles is sufficient to perform an exchange. If so, exchange the empty bottles for full ones, which also increases the `numExchange` count by one.
3. **Repeat**: Continue this process until there are not enough empty bottles to perform any exchanges.

### Data Structures:
- Use simple integer variables to keep track of the number of full bottles, empty bottles, and the total count of bottles drunk. No complex data structures are needed due to the straightforward nature of the problem.

### Complexity:
- **Time Complexity**: O(n), where n is the number of times we can drink and exchange bottles. Given the constraints (both `numBottles` and `numExchange` can go up to 100), this results in a manageable number of iterations.
- **Space Complexity**: O(1), as we are only using a fixed number of variables regardless of the input size.

This approach effectively simulates the process of drinking and exchanging bottles, ensuring that we maximize the total number of bottles consumed while adhering to the exchange rules.
