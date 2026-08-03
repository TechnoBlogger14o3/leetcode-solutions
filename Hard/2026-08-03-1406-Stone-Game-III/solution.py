class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        n = len(stoneValue)
        dp = [float('-inf')] * (n + 1)
        dp[n] = 0
        
        for i in range(n - 1, -1, -1):
            total = 0
            for j in range(1, 4):
                if i + j <= n:
                    total += stoneValue[i + j - 1]
                    dp[i] = max(dp[i], total - dp[i + j])
        
        if dp[0] > 0:
            return "Alice"
        elif dp[0] < 0:
            return "Bob"
        else:
            return "Tie"