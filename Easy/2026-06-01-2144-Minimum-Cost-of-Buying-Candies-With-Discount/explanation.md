# Minimum Cost of Buying Candies With Discount (Easy)

**Problem ID:** 2144  
**Date:** 2026-06-01  
**Link:** https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/

## Approach

To solve the problem of finding the minimum cost of buying candies with a discount, we can adopt a greedy approach. The main idea is to maximize the value of the free candy we receive by strategically selecting which candies to buy.

### Approach:

1. **Sorting**: First, we sort the array of candy costs in descending order. This allows us to always consider the most expensive candies first, which helps in maximizing the value of the free candy we can get.

2. **Grouping**: We iterate through the sorted list of costs in groups of three. For every three candies, we will:
   - Buy the two most expensive candies (the first two in the current group).
   - Get the third candy (the cheapest in the group of three) for free, as long as it is less than or equal to the minimum of the two purchased candies.

3. **Cost Calculation**: For each group of three:
   - Add the costs of the two purchased candies to the total.
   - Skip the cost of the free candy when calculating the total cost.

4. **Handling Remaining Candies**: If there are fewer than three candies left after processing in groups of three, we simply add their costs to the total since they cannot be paired to receive a discount.

### Data Structures:
- An array to hold the costs of the candies.
- A simple loop for iteration and a counter to manage the grouping.

### Complexity:
- **Time Complexity**: O(n log n) due to the sorting step, where n is the number of candies.
- **Space Complexity**: O(1) if we disregard the input storage, as we only use a few additional variables for calculations.

This approach ensures that we minimize the total cost by effectively utilizing the discount mechanism provided by the shop. By always selecting the most expensive candies first, we maximize the value of the free candy we can take, leading to the minimum overall expenditure.
