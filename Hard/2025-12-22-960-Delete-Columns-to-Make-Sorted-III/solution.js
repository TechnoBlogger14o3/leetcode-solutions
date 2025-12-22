var minDeletionSize = function(strs) {
    const n = strs.length;
    const m = strs[0].length;
    const dp = new Array(m).fill(1);
    
    for (let j = 0; j < m; j++) {
        for (let i = 1; i < n; i++) {
            if (strs[i][j] >= strs[i - 1][j]) {
                dp[j] = Math.max(dp[j], dp[j - 1] + 1);
            } else {
                dp[j] = Math.max(dp[j], 1);
            }
        }
    }
    
    return m - Math.max(...dp);
};