var stoneGameIII = function(stoneValue) {
    const n = stoneValue.length;
    const dp = new Array(n + 1).fill(-Infinity);
    dp[n] = 0;

    for (let i = n - 1; i >= 0; i--) {
        let sum = 0;
        for (let j = 1; j <= 3; j++) {
            if (i + j - 1 < n) {
                sum += stoneValue[i + j - 1];
                dp[i] = Math.max(dp[i], sum - dp[i + j]);
            }
        }
    }

    if (dp[0] > 0) return "Alice";
    if (dp[0] < 0) return "Bob";
    return "Tie";
};