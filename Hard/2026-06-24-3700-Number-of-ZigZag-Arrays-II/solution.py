class Solution:
    def zigzagArrays(self, n: int, l: int, r: int) -> int:
        MOD = 10**9 + 7
        m = r - l + 1
        
        if n == 1:
            return m % MOD
        
        # dp[i][0] = number of valid zigzag arrays of length i ending with a peak
        # dp[i][1] = number of valid zigzag arrays of length i ending with a valley
        dp = [[0, 0] for _ in range(2)]
        
        dp[0][0] = m  # Length 1, can be any number in [l, r]
        dp[0][1] = 0  # No valleys for length 1
        
        for i in range(2, n + 1):
            dp[i % 2][0] = (dp[(i - 1) % 2][0] * (m - 1) + dp[(i - 1) % 2][1] * (m - 1)) % MOD
            dp[i % 2][1] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][1] * (m - 2)) % MOD
        
        return (dp[n % 2][0] + dp[n % 2][1]) % MOD