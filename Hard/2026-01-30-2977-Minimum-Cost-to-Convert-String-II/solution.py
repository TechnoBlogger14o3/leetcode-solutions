from collections import defaultdict
import sys

class Solution:
    def minimumCost(self, source: str, target: str, original: list[str], changed: list[str], cost: list[int]) -> int:
        n = len(source)
        dp = [[sys.maxsize] * (n + 1) for _ in range(n + 1)]
        dp[0][0] = 0
        
        # Create a mapping from original to (changed, cost)
        change_map = defaultdict(list)
        for o, c, co in zip(original, changed, cost):
            change_map[o].append((c, co))
        
        for i in range(n):
            for j in range(n + 1):
                # Carry forward the previous cost
                dp[i + 1][j] = min(dp[i + 1][j], dp[i][j])
                
                # If source[i] matches target[j], no cost
                if j < n and source[i] == target[j]:
                    dp[i + 1][j + 1] = min(dp[i + 1][j + 1], dp[i][j])
                
                # Check for possible changes
                for length in range(1, n - i + 1):
                    sub = source[i:i + length]
                    if j + length <= n and sub in change_map:
                        for new_sub, c in change_map[sub]:
                            if new_sub == target[j:j + length]:
                                dp[i + length][j + length] = min(dp[i + length][j + length], dp[i][j] + c)
        
        result = min(dp[n][j] for j in range(n + 1) if target[j:] == '')
        return result if result < sys.maxsize else -1