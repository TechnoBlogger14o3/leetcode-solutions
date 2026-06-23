var zigzagCount = function(n, l, r) {
    const MOD = 1e9 + 7;
    const range = r - l + 1;
    
    if (n < 3 || range < 1) return 0;

    let dp = Array.from({ length: n + 1 }, () => Array(2).fill(0));
    dp[1][0] = range; // last was increasing
    dp[1][1] = range; // last was decreasing

    for (let i = 2; i <= n; i++) {
        dp[i][0] = (dp[i - 1][1] * (range - 1)) % MOD; // last was increasing
        dp[i][1] = (dp[i - 1][0] * (range - 1)) % MOD; // last was decreasing

        if (i > 2) {
            dp[i][0] = (dp[i][0] + dp[i - 2][1] * (range - 1)) % MOD; // last was increasing
            dp[i][1] = (dp[i][1] + dp[i - 2][0] * (range - 1)) % MOD; // last was decreasing
        }
    }

    return (dp[n][0] + dp[n][1]) % MOD;
};