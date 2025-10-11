# Coin Change

## Problem Statement

You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.

You may assume that you have an infinite number of each kind of coin.

## Examples

**Example 1:**
```
Input: coins = [1,3,4], amount = 6
Output: 2
Explanation: 6 = 3 + 3
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP to store minimum coins for each amount
2. dp[i] = min(dp[i], dp[i-coin] + 1) for each coin
3. Initialize dp[0] = 0, others = infinity
4. Most efficient approach

**Time Complexity:** O(amount * coins.length)
**Space Complexity:** O(amount) - DP array

### Method 2: BFS
1. Use BFS to find minimum steps
2. Each level represents one coin
3. Less efficient than DP

**Time Complexity:** O(amount * coins.length)
**Space Complexity:** O(amount) - Queue

## Algorithm

```
1. Initialize dp[0] = 0, dp[i] = infinity for i > 0
2. For each amount from 1 to amount:
   a. For each coin:
      b. If coin <= amount: dp[amount] = min(dp[amount], dp[amount-coin] + 1)
3. Return dp[amount] or -1 if infinity
```

## Key Insights

- **State Transition**: dp[i] = min(dp[i], dp[i-coin] + 1)
- **Infinite Coins**: Can use same coin multiple times
- **Minimum Coins**: Find minimum number of coins
- **Impossible Case**: Return -1 if amount cannot be made

## Alternative Approaches

1. **BFS**: Use BFS for minimum steps
2. **Recursion**: Use recursive approach with memoization
3. **Greedy**: Not always optimal

## Edge Cases

- Empty coins: Return -1
- Amount = 0: Return 0
- No solution: Return -1
- Single coin: Handle appropriately

## Applications

- Dynamic programming patterns
- Optimization problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Dynamic Programming**: Most efficient approach
- **Single Pass**: O(amount * coins) time complexity
- **Space Efficient**: O(amount) space complexity
- **No Recursion**: Avoid stack overflow
