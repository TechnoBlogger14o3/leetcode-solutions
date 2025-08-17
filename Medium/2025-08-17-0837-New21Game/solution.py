class Solution:
    def new21Game(self, N: int, K: int, maxPts: int) -> float:
        if K == 0 or N >= K - 1 + maxPts:
            return 1.0
        dp = [0.0] * (N + 1)
        dp[0] = 1.0
        probability, window_sum = 0.0, 1.0
        for i in range(1, N + 1):
            dp[i] = window_sum / maxPts
            if i < K:
                window_sum += dp[i]
            else:
                probability += dp[i]
            if i >= maxPts:
                window_sum -= dp[i - maxPts]
        return probability
