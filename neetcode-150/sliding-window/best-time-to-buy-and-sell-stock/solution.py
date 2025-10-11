"""
Time Complexity: O(n) - Single pass through the array
Space Complexity: O(1) - Only using two variables
"""
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        
        min_price = prices[0]
        max_profit = 0
        
        for i in range(1, len(prices)):
            # Update minimum price seen so far
            min_price = min(min_price, prices[i])
            
            # Calculate profit if we sell today
            profit = prices[i] - min_price
            
            # Update maximum profit
            max_profit = max(max_profit, profit)
        
        return max_profit

# Alternative approach using brute force
class SolutionBruteForce:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        
        for i in range(len(prices)):
            for j in range(i + 1, len(prices)):
                profit = prices[j] - prices[i]
                max_profit = max(max_profit, profit)
        
        return max_profit

# More concise version
class SolutionConcise:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = float('inf')
        max_profit = 0
        
        for price in prices:
            min_price = min(min_price, price)
            max_profit = max(max_profit, price - min_price)
        
        return max_profit

# Using enumerate for more Pythonic approach
class SolutionPythonic:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        
        min_price = prices[0]
        max_profit = 0
        
        for price in prices[1:]:
            min_price = min(min_price, price)
            max_profit = max(max_profit, price - min_price)
        
        return max_profit

# One-liner using reduce
from functools import reduce

class SolutionOneLiner:
    def maxProfit(self, prices: List[int]) -> int:
        return reduce(lambda acc, price: (min(acc[0], price), max(acc[1], price - acc[0])), 
                     prices, (float('inf'), 0))[1] if prices else 0
