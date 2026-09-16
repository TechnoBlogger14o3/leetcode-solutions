var numberOfSets = function(n, k) {
    const MOD = 1e9 + 7;
    const dp = Array.from({ length: k + 1 }, () => Array(n + 1).fill(0));
    
    for (let i = 0; i <= n; i++) {
        dp[0][i] = 1; // Base case: 1 way to choose 0 segments
    }
    
    for (let segments = 1; segments <= k; segments++) {
        for (let points = 2 * segments; points <= n; points++) {
            for (let start = 0; start <= points - 2; start++) {
                dp[segments][points] = (dp[segments][points] + dp[segments - 1][start]) % MOD;
            }
        }
    }
    
    let result = 0;
    for (let i = 2 * k; i <= n; i++) {
        result = (result + dp[k][i]) % MOD;
    }
    
    return result;
};