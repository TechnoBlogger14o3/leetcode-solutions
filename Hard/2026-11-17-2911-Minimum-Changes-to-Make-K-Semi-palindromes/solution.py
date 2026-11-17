class Solution:
    def minChanges(self, s: str, k: int) -> int:
        n = len(s)
        
        def min_changes_to_semi_palindrome(sub: str) -> int:
            m = len(sub)
            changes = 0
            for i in range((m + 1) // 2):
                left = sub[i]
                right = sub[m - 1 - i]
                if left != right:
                    changes += 1
            return changes
        
        # Precompute the changes needed for each possible substring
        dp = [[0] * (k + 1) for _ in range(n + 1)]
        
        for i in range(1, n + 1):
            dp[i][1] = min_changes_to_semi_palindrome(s[:i])
        
        for j in range(2, k + 1):
            for i in range(j, n + 1):
                dp[i][j] = float('inf')
                for p in range(j - 1, i):
                    dp[i][j] = min(dp[i][j], dp[p][j - 1] + min_changes_to_semi_palindrome(s[p:i]))
        
        return dp[n][k]