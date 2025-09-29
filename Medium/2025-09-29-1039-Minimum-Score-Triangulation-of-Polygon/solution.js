var minScoreTriangulation = function(values) {
    const n = values.length;
    const dp = Array.from({ length: n }, () => Array(n).fill(0));

    for (let len = 2; len < n; len++) {
        for (let i = 0; i < n - len; i++) {
            const j = i + len;
            dp[i][j] = Infinity;
            for (let k = i + 1; k < j; k++) {
                const score = values[i] * values[k] * values[j];
                dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + score);
            }
        }
    }

    return dp[0][n - 1];
};