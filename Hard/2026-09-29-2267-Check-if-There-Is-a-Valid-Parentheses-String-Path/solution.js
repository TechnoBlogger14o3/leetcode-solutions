var hasValidPath = function(grid) {
    const m = grid.length, n = grid[0].length;
    const dp = Array.from({ length: m }, () => Array(n).fill(false));
    
    dp[0][0] = grid[0][0] === '(';

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === '(') {
                if (i > 0) dp[i][j] = dp[i][j] || dp[i - 1][j];
                if (j > 0) dp[i][j] = dp[i][j] || dp[i][j - 1];
            } else {
                if (i > 0 && dp[i - 1][j]) dp[i][j] = true;
                if (j > 0 && dp[i][j - 1]) dp[i][j] = true;
            }
        }
    }

    let openCount = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === '(') openCount++;
            else openCount--;
            if (openCount < 0) return false;
        }
    }

    return openCount === 0 && dp[m - 1][n - 1];
};