class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        MOD = 10**9 + 7
        dp = [0] * (n + 1)
        dp[1] = 1
        
        for day in range(2, n + 1):
            if day >= delay:
                dp[day] += dp[day - delay]
            if day >= forget:
                dp[day] -= dp[day - forget]
            dp[day] = (dp[day] + dp[day - 1]) % MOD
        
        return sum(dp[day] for day in range(n - forget + 1, n + 1)) % MOD