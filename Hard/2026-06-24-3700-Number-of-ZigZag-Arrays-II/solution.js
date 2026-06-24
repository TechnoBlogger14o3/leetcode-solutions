var zigzagCount = function(n, l, r) {
    const MOD = 1e9 + 7;
    const m = r - l + 1;

    if (n === 1) return m % MOD;
    if (n === 2) return (m * (m - 1)) % MOD;

    const dp = new Array(n + 1).fill(0).map(() => new Array(3).fill(0));
    dp[1][0] = m; // last element is increasing
    dp[1][1] = m; // last element is decreasing
    dp[1][2] = 0; // last element is equal

    for (let i = 2; i <= n; i++) {
        dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) * (m - 1) % MOD; // last is increasing
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) * (m - 1) % MOD; // last is decreasing
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD; // last is equal
    }

    return (dp[n][0] + dp[n][1]) % MOD;
};