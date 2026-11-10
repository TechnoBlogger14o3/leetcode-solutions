class Solution:
    def minCost(self, n: int, costs: List[int]) -> int:
        dp = [0] * (n + 1)
        
        for i in range(1, n + 1):
            dp[i] = float('inf')
            for jump in range(1, 4):
                if i - jump >= 0:
                    cost = costs[i - jump] + (jump ** 2)
                    dp[i] = min(dp[i], dp[i - jump] + cost)
        
        return dp[n]