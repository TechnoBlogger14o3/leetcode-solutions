class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        n = len(strs)
        m = len(strs[0])
        dp = [1] * n
        result = 0
        
        for j in range(m):
            for i in range(1, n):
                if strs[i][j] < strs[i - 1][j]:
                    dp[i] = max(dp[i], dp[i - 1])
            result += 1
            for i in range(n):
                if dp[i] == i + 1:
                    dp[i] = 1
                else:
                    dp[i] += 1
        
        return result