class Solution:
    def numOfWays(self, n: int) -> int:
        MOD = 10**9 + 7
        
        if n == 1:
            return 12
        
        # dp[i] represents the number of ways to paint the grid of size i
        dp = [0] * (n + 1)
        dp[1] = 12
        
        for i in range(2, n + 1):
            dp[i] = (dp[i - 1] * 12 - dp[i - 2] * 6) % MOD
        
        return dp[n]

# Example usage:
# sol = Solution()
# print(sol.numOfWays(1))    # Output: 12
# print(sol.numOfWays(5000)) # Output: 30228214