from typing import List

class Solution:
    def maxCollectedFruits(self, fruits: List[List[int]]) -> int:
        n = len(fruits)
        ans = 0
        
        # Collect fruits from main diagonal
        for i in range(n):
            ans += fruits[i][i]

        # Dynamic programming function
        def dp():
            prev = [float('-inf')] * n
            curr = [float('-inf')] * n
            prev[n - 1] = fruits[0][n - 1]
            
            for i in range(1, n - 1):
                for j in range(max(n - 1 - i, i + 1), n):
                    best = prev[j]
                    if j - 1 >= 0:
                        best = max(best, prev[j - 1])
                    if j + 1 < n:
                        best = max(best, prev[j + 1])
                    curr[j] = best + fruits[i][j]
                prev, curr = curr, prev
            
            return prev[n - 1]

        ans += dp()

        # Transpose the grid
        for i in range(n):
            for j in range(i):
                fruits[j][i], fruits[i][j] = fruits[i][j], fruits[j][i]

        ans += dp()
        return ans 