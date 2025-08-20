from typing import List

class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for _ in range(m)]
        count = 0
        
        # Fill first row
        for j in range(n):
            dp[0][j] = matrix[0][j]
            count += dp[0][j]
        
        # Fill first column
        for i in range(1, m):
            dp[i][0] = matrix[i][0]
            count += dp[i][0]
        
        # Fill rest of the dp table
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == 1:
                    # dp[i][j] = min of left, top, and top-left + 1
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    count += dp[i][j]
        
        return count



