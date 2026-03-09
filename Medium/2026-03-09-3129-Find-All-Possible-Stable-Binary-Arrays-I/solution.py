class Solution:
    def countStableArrays(self, zero: int, one: int, limit: int) -> int:
        MOD = 10**9 + 7
        
        # dp[i][j] will store the number of stable arrays with i zeros and j ones
        dp = [[0] * (one + 1) for _ in range(zero + 1)]
        dp[0][1] = 1  # Base case: one way to have one 1 and no 0s
        
        for i in range(zero + 1):
            for j in range(1, one + 1):
                # If we can add a 0
                if i > 0:
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD
                
                # If we can add a 1
                if j > 1:
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD
                
                # If we can add a 0 and a 1 together
                if i > 0 and j > 0:
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD
                
                # Remove invalid configurations
                if i + j > limit:
                    dp[i][j] = (dp[i][j] - dp[i][j - 1]) % MOD
        
        return dp[zero][one]

# Example usage
# sol = Solution()
# print(sol.countStableArrays(1, 1, 2))  # Output: 2
# print(sol.countStableArrays(1, 2, 1))  # Output: 1
# print(sol.countStableArrays(3, 3, 2))  # Output: 14