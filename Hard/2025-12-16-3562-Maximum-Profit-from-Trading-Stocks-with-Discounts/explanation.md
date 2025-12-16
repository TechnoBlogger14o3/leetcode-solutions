# Maximum Profit from Trading Stocks with Discounts (Hard)

**Problem ID:** 3562  
**Date:** 2025-12-16  
**Link:** https://leetcode.com/problems/maximum-profit-from-trading-stocks-with-discounts/

## Approach

To solve the problem of maximizing profit from stock trading with discounts in a company hierarchy, we can employ a dynamic programming approach combined with a depth-first search (DFS) strategy.

### Main Idea:
The goal is to determine the maximum profit achievable by selecting which employees can buy stocks while respecting the budget constraint. Each employee can either buy their stock at the regular price or, if their direct boss buys their stock, at a discounted price. The challenge lies in optimizing the selection of employees to maximize profit without exceeding the budget.

### Approach:
1. **Graph Representation**: First, represent the hierarchy using an adjacency list. This allows us to easily traverse the relationships between employees.

2. **Profit Calculation**: For each employee, calculate the profit they can make if they buy their stock at the regular price and at the discounted price (if applicable). Store these profits in a list.

3. **Dynamic Programming Setup**: Use a dynamic programming array `dp` where `dp[b]` represents the maximum profit achievable with a budget of `b`. The size of this array will be `budget + 1`.

4. **DFS for Employee Selection**: Implement a DFS function that explores all possible combinations of employees buying stocks. For each employee, consider:
   - Buying at the regular price.
   - Buying at the discounted price (if their boss has bought).
   - Not buying at all.
   For each choice, update the `dp` array accordingly.

5. **Budget Management**: Ensure that when an employee's stock is bought, the budget is updated, and only valid budget states are considered.

6. **Result Extraction**: After processing all employees, the maximum value in the `dp` array will represent the maximum profit achievable within the given budget.

### Data Structures:
- **Adjacency List**: To represent the hierarchy of employees.
- **Dynamic Programming Array**: To track the maximum profit for each budget state.

### Complexity:
- **Time Complexity**: The overall complexity is O(n * budget), where `n` is the number of employees and `budget` is the maximum budget allowed. The DFS may explore multiple combinations, but due to the constraints (with `n` and `budget` both ≤ 160), this is manageable.
- **Space Complexity**: O(n + budget), accounting for the adjacency list and the dynamic programming array.

By following this structured approach, we can efficiently determine the maximum profit achievable from stock trading within the constraints provided.
