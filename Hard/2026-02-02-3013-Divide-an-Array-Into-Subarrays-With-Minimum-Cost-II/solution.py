class Solution:
    def minCost(self, nums: List[int], k: int, dist: int) -> int:
        n = len(nums)
        dp = [[float('inf')] * (k + 1) for _ in range(n + 1)]
        dp[0][0] = 0
        
        for i in range(1, n + 1):
            for j in range(1, k + 1):
                min_cost = float('inf')
                for p in range(i - 1, max(-1, i - dist - 1), -1):
                    min_cost = min(min_cost, dp[p][j - 1] + nums[p])
                dp[i][j] = min_cost
        
        return dp[n][k]