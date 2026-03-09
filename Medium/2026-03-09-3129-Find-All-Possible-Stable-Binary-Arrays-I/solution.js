var countStableArrays = function(zero, one, limit) {
    const MOD = 1e9 + 7;
    const dp = Array.from({ length: zero + 1 }, () => Array(one + 1).fill(0));
    dp[0][1] = 1; // Base case: one way to have one '1' and no '0's

    for (let z = 0; z <= zero; z++) {
        for (let o = 1; o <= one; o++) {
            if (z > 0) {
                dp[z][o] = (dp[z][o] + dp[z - 1][o]) % MOD; // Add '0' at the end
            }
            if (o > 1) {
                dp[z][o] = (dp[z][o] + dp[z][o - 1]) % MOD; // Add '1' at the end
            }
            if (z > 0 && o > 1 && z + o > limit) {
                dp[z][o] = (dp[z][o] - dp[z - 1][o - 1] + MOD) % MOD; // Remove invalid cases
            }
        }
    }
    
    return dp[zero][one];
};