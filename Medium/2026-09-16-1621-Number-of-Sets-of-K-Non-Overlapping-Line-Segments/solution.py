class Solution:
    def numberOfSets(self, n: int, k: int) -> int:
        MOD = 10**9 + 7
        
        # dp[i][j] will store the number of ways to draw j segments using the first i points
        dp = [[0] * (k + 1) for _ in range(n + 1)]
        
        # Base case: 0 segments can be drawn in 1 way (by not drawing any)
        for i in range(n + 1):
            dp[i][0] = 1
        
        for j in range(1, k + 1):
            for i in range(2 * j, n + 1):
                # dp[i][j] = dp[i-1][j] + dp[i-2][j-1] + dp[i-3][j-1] + ... + dp[j][j-1]
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD
        
        return dp[n][k]

# Example usage:
# sol = Solution()
# print(sol.numberOfSets(4, 2))  # Output: 5
# print(sol.numberOfSets(3, 1))  # Output: 3
# print(sol.numberOfSets(30, 7))  # Output: 796297179