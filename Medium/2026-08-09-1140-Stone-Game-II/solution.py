class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        prefix_sum = [0] * (n + 1)

        for i in range(n):
            prefix_sum[i + 1] = prefix_sum[i] + piles[i]

        def dfs(i, M):
            if i >= n:
                return 0
            if dp[i][M] != 0:
                return dp[i][M]
            max_stones = 0
            for x in range(1, 2 * M + 1):
                if i + x <= n:
                    max_stones = max(max_stones, prefix_sum[i + x] - dfs(i + x, max(M, x)))
            dp[i][M] = max_stones
            return max_stones

        return dfs(0, 1)