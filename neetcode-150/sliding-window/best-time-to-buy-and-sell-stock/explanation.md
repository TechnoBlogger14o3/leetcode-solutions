# Best Time to Buy and Sell Stock

## Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

## Examples

**Example 1:**
```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

**Example 2:**
```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
```

## Approach

### Method 1: One Pass (Recommended)
1. Keep track of minimum price seen so far
2. For each day, calculate profit if we sell today
3. Update maximum profit if current profit is better

**Time Complexity:** O(n) - Single pass through the array
**Space Complexity:** O(1) - Only using two variables

### Method 2: Brute Force
1. Check all possible buy-sell pairs
2. Return maximum profit

**Time Complexity:** O(n²) - Nested loops
**Space Complexity:** O(1) - No extra space

## Algorithm

```
1. Initialize minPrice = prices[0], maxProfit = 0
2. For each price in prices:
   a. Update minPrice = min(minPrice, price)
   b. Calculate profit = price - minPrice
   c. Update maxProfit = max(maxProfit, profit)
3. Return maxProfit
```

## Key Insights

- **One Pass**: Can solve in single iteration
- **Minimum Tracking**: Keep track of lowest price seen
- **Greedy Strategy**: Always consider selling at current price
- **No Future Knowledge**: Can only use past and current information

## Alternative Approaches

1. **Brute Force**: Check all pairs - O(n²) time
2. **Dynamic Programming**: More complex state tracking
3. **Divide and Conquer**: Recursive approach

## Edge Cases

- Empty array: Return 0
- Single element: Return 0
- Decreasing prices: Return 0
- All same prices: Return 0
- Single transaction: Only one buy-sell pair

## Applications

- Financial analysis
- Algorithm design patterns
- Interview preparation
- Trading algorithms
- Optimization problems

## Optimization Opportunities

- **Single Pass**: Most efficient approach
- **Early Exit**: Stop if no profit possible
- **Memory Efficient**: O(1) space solution
- **Greedy Choice**: Always consider current day for selling
