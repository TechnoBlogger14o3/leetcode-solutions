class Solution:
    def zigzagArrays(self, n: int, l: int, r: int) -> int:
        MOD = 10**9 + 7
        range_size = r - l + 1
        
        if range_size < 2:
            return 0
        
        dp = [[0] * 2 for _ in range(n)]
        dp[1][0] = range_size  # last element is increasing
        dp[1][1] = range_size  # last element is decreasing
        
        for i in range(2, n):
            dp[i][0] = (dp[i - 1][1] * (range_size - 1)) % MOD  # last is increasing
            dp[i][1] = (dp[i - 1][0] * (range_size - 1)) % MOD  # last is decreasing
            
            if i > 2:
                dp[i][0] = (dp[i][0] + dp[i - 2][0] * (range_size - 1)) % MOD  # last is increasing
                dp[i][1] = (dp[i][1] + dp[i - 2][1] * (range_size - 1)) % MOD  # last is decreasing
        
        return (dp[n - 1][0] + dp[n - 1][1]) % MOD