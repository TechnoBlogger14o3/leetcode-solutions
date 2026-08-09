var stoneGameII = function(piles) {
    const n = piles.length;
    const dp = Array.from({ length: n + 1 }, () => Array(n + 1).fill(0));
    const prefixSum = new Array(n + 1).fill(0);

    for (let i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + piles[i];
    }

    const dfs = (i, m) => {
        if (i >= n) return 0;
        if (dp[i][m] !== 0) return dp[i][m];

        let maxStones = 0;
        for (let x = 1; x <= 2 * m; x++) {
            if (i + x > n) break;
            const stones = prefixSum[i + x] - prefixSum[i];
            maxStones = Math.max(maxStones, stones - dfs(i + x, Math.max(m, x)));
        }

        dp[i][m] = maxStones;
        return maxStones;
    };

    return dfs(0, 1);
};