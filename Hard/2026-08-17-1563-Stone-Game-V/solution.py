class Solution:
    def stoneGameV(self, stoneValue: List[int]) -> int:
        n = len(stoneValue)
        prefix_sum = [0] * (n + 1)
        for i in range(n):
            prefix_sum[i + 1] = prefix_sum[i] + stoneValue[i]
        
        dp = [[0] * n for _ in range(n)]
        
        for length in range(2, n + 1):
            for left in range(n - length + 1):
                right = left + length - 1
                for mid in range(left, right):
                    left_sum = prefix_sum[mid + 1] - prefix_sum[left]
                    right_sum = prefix_sum[right + 1] - prefix_sum[mid + 1]
                    if left_sum < right_sum:
                        dp[left][right] = max(dp[left][right], dp[left][mid] + left_sum)
                    elif left_sum > right_sum:
                        dp[left][right] = max(dp[left][right], dp[mid + 1][right] + right_sum)
                    else:
                        dp[left][right] = max(dp[left][right], dp[left][mid] + left_sum, dp[mid + 1][right] + right_sum)
        
        return dp[0][n - 1]