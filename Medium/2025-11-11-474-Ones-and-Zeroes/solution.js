var findMaxForm = function(strs, m, n) {
    const dp = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));

    for (const str of strs) {
        const count0 = (str.match(/0/g) || []).length;
        const count1 = str.length - count0;

        for (let i = m; i >= count0; i--) {
            for (let j = n; j >= count1; j--) {
                dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
            }
        }
    }

    return dp[m][n];
};