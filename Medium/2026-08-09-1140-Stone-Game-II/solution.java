class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }

        return dfs(0, 1, piles, dp, prefixSum);
    }

    private int dfs(int index, int M, int[] piles, int[][] dp, int[] prefixSum) {
        if (index >= piles.length) return 0;
        if (dp[index][M] != 0) return dp[index][M];

        int maxStones = 0;
        for (int x = 1; x <= 2 * M; x++) {
            if (index + x > piles.length) break;
            int stones = prefixSum[index + x] - prefixSum[index];
            maxStones = Math.max(maxStones, stones + prefixSum[piles.length] - prefixSum[index + x] - dfs(index + x, Math.max(M, x), piles, dp, prefixSum));
        }

        dp[index][M] = maxStones;
        return maxStones;
    }
}