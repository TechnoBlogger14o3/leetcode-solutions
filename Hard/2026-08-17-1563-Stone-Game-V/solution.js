var stoneGameV = function(stoneValue) {
    const n = stoneValue.length;
    const dp = new Array(n).fill(0).map(() => new Array(n).fill(0));
    const prefixSum = new Array(n + 1).fill(0);

    for (let i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
    }

    for (let length = 2; length <= n; length++) {
        for (let i = 0; i <= n - length; i++) {
            const j = i + length - 1;
            for (let k = i; k < j; k++) {
                const leftSum = prefixSum[k + 1] - prefixSum[i];
                const rightSum = prefixSum[j + 1] - prefixSum[k + 1];
                if (leftSum < rightSum) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + leftSum);
                } else if (leftSum > rightSum) {
                    dp[i][j] = Math.max(dp[i][j], dp[k + 1][j] + rightSum);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + leftSum, dp[k + 1][j] + rightSum);
                }
            }
        }
    }

    return dp[0][n - 1];
};