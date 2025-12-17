class Solution:
    def maxProfit(self, prices: List[int], k: int) -> int:
        n = len(prices)
        if n == 0 or k == 0:
            return 0
        
        # If k is greater than half the number of days, we can make unlimited transactions
        if k >= n // 2:
            return sum(max(prices[i + 1] - prices[i], 0) for i in range(n - 1))
        
        # DP table
        dp = [[0] * (k + 1) for _ in range(n)]
        
        for j in range(1, k + 1):
            max_diff = -prices[0]
            for i in range(1, n):
                dp[i][j] = max(dp[i - 1][j], prices[i] + max_diff)
                max_diff = max(max_diff, dp[i][j - 1] - prices[i])
        
        return dp[n - 1][k]