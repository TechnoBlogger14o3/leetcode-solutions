class Solution:
    def numberOfWays(self, n: int, x: int) -> int:
        MOD = 1000000007
        
        # dp[i][j] represents the number of ways to express i using powers up to j^x
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        
        # Base case: there's 1 way to express 0 (empty sum)
        dp[0][0] = 1
        
        # For each possible sum
        for sum_val in range(n + 1):
            # For each possible power base
            for base in range(1, n + 1):
                power = base ** x
                
                # If power exceeds the sum, we can't use this base
                if power > sum_val:
                    dp[sum_val][base] = dp[sum_val][base - 1]
                else:
                    # We can either use this power or not
                    # If we use it: dp[sum_val - power][base - 1]
                    # If we don't use it: dp[sum_val][base - 1]
                    dp[sum_val][base] = (dp[sum_val][base - 1] + dp[sum_val - power][base - 1]) % MOD
        
        return dp[n][n]
