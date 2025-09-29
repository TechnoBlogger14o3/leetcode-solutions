class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        n = len(values)
        dp = [[0] * n for _ in range(n)]
        
        for length in range(2, n):  # length of the triangle base
            for i in range(n - length):
                j = i + length
                dp[i][j] = float('inf')
                for k in range(i + 1, j):
                    score = values[i] * values[k] * values[j]
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j] + score)
        
        return dp[0][n - 1]