var minCost = function(n, costs) {
    const dp = new Array(n + 1).fill(Infinity);
    dp[0] = 0;

    for (let i = 0; i < n; i++) {
        for (let j = 1; j <= 3; j++) {
            if (i + j <= n) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + costs[i + j - 1] + j * j);
            }
        }
    }

    return dp[n];
};