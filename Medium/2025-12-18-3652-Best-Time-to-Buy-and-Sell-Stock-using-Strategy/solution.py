class Solution:
    def maximumProfit(self, prices: List[int], strategy: List[int], k: int) -> int:
        n = len(prices)
        
        # Calculate initial profit
        initial_profit = sum(strategy[i] * prices[i] for i in range(n))
        
        max_profit = initial_profit
        
        # Sliding window to calculate the effect of modification
        for i in range(n - k + 1):
            # Calculate the profit change if we modify the segment [i, i + k - 1]
            profit_change = 0
            
            # First half to hold (0)
            for j in range(i, i + k // 2):
                profit_change += strategy[j] * prices[j]  # Remove current profit
                profit_change -= 0 * prices[j]            # Add new profit (0)
            
            # Second half to sell (1)
            for j in range(i + k // 2, i + k):
                profit_change += strategy[j] * prices[j]  # Remove current profit
                profit_change += 1 * prices[j]            # Add new profit (1)
            
            max_profit = max(max_profit, initial_profit - profit_change)
        
        return max_profit