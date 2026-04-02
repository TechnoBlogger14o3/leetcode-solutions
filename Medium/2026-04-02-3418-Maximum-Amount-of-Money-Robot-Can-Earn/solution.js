var maxCoins = function(coins) {
    const m = coins.length;
    const n = coins[0].length;
    const dp = Array.from({ length: m }, () => Array.from({ length: n }, () => Array(3).fill(-Infinity)));
    
    dp[0][0][0] = coins[0][0] >= 0 ? coins[0][0] : 0;
    if (coins[0][0] < 0) dp[0][0][1] = -coins[0][0];
    if (coins[0][0] < 0) dp[0][0][2] = -coins[0][0];

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            for (let k = 0; k < 3; k++) {
                if (i === 0 && j === 0) continue;

                const currentCoins = coins[i][j];
                const gain = currentCoins >= 0 ? currentCoins : 0;
                const loss = currentCoins < 0 ? -currentCoins : 0;

                if (i > 0) {
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k] + gain);
                    if (k > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1] + gain);
                    }
                    if (k > 0 && loss > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1]);
                    }
                }
                if (j > 0) {
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k] + gain);
                    if (k > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1] + gain);
                    }
                    if (k > 0 && loss > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1]);
                    }
                }
            }
        }
    }

    return Math.max(dp[m - 1][n - 1][0], dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]);
};