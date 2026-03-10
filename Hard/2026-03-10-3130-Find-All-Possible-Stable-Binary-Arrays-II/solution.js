const MOD = 1e9 + 7;

var countStableArrays = function(zero, one, limit) {
    const dp = Array.from({ length: zero + 1 }, () => Array(one + 1).fill(0));
    dp[0][1] = 1; // Base case: one way to have one '1' and no '0's

    for (let z = 0; z <= zero; z++) {
        for (let o = 0; o <= one; o++) {
            if (z > 0) {
                dp[z][o] = (dp[z][o] + dp[z - 1][o]) % MOD; // Add a '0'
            }
            if (o > 1) {
                dp[z][o] = (dp[z][o] + dp[z][o - 1]) % MOD; // Add a '1'
            }
            if (z > 0 && o > 0 && z + o > limit) {
                dp[z][o] = (dp[z][o] - dp[z - 1][o - 1] + MOD) % MOD; // Remove invalid cases
            }
        }
    }

    let result = 0;
    for (let z = 0; z <= zero; z++) {
        result = (result + dp[z][one]) % MOD;
    }

    return result;
};