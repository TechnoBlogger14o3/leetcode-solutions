# Water Bottles (Easy)

**Problem ID:** 1518  
**Date:** 2025-10-01  
**Link:** https://leetcode.com/problems/water-bottles/

## Approach

To solve the "Water Bottles" problem, we can use a straightforward iterative approach to track the total number of water bottles consumed. The main idea is to continuously drink from the available full bottles and exchange the resulting empty bottles for new full ones until no more exchanges can be made.

### Approach:

1. **Initialization**: Start with the total number of full bottles (`numBottles`) and initialize a counter for the total number of bottles consumed.

2. **Iterative Drinking and Exchanging**:
   - While there are full bottles available:
     - Drink all the full bottles, adding this number to the total consumed count.
     - Calculate the number of empty bottles generated from drinking.
     - Determine how many new full bottles can be obtained by exchanging the empty bottles. This is done by integer division of the number of empty bottles by `numExchange`.
     - Update the count of empty bottles to reflect those exchanged and those remaining after the exchange.

3. **Termination**: The process continues until the number of empty bottles is less than `numExchange`, meaning no further exchanges can be made.

### Data Structures:
- We primarily use integer variables to keep track of the number of full bottles, empty bottles, and the total consumed count. No complex data structures are required due to the simplicity of the problem.

### Complexity:
- **Time Complexity**: O(log(numBottles)), where the logarithmic factor arises because the number of full bottles decreases significantly with each round of exchanges and drinking.
- **Space Complexity**: O(1), as we only use a fixed number of variables regardless of the input size.

This approach efficiently calculates the maximum number of water bottles that can be consumed through a simple loop, ensuring clarity and directness in the solution.
