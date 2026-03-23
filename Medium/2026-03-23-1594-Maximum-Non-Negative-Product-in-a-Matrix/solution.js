var maxProductPath = function(grid) {
    const MOD = 1e9 + 7;
    const m = grid.length;
    const n = grid[0].length;
    
    let dp = Array.from({ length: m }, () => Array(n).fill([0, 0]));
    dp[0][0] = grid[0][0] >= 0 ? [grid[0][0], 1] : [1, grid[0][0]];
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (i === 0 && j === 0) continue;
            let maxProd = -Infinity;
            let minProd = Infinity;
            
            if (i > 0) {
                const [upMax, upMin] = dp[i - 1][j];
                maxProd = Math.max(maxProd, upMax * grid[i][j], upMin * grid[i][j]);
                minProd = Math.min(minProd, upMax * grid[i][j], upMin * grid[i][j]);
            }
            if (j > 0) {
                const [leftMax, leftMin] = dp[i][j - 1];
                maxProd = Math.max(maxProd, leftMax * grid[i][j], leftMin * grid[i][j]);
                minProd = Math.min(minProd, leftMax * grid[i][j], leftMin * grid[i][j]);
            }
            
            dp[i][j] = [maxProd, minProd];
        }
    }
    
    const [finalMax, finalMin] = dp[m - 1][n - 1];
    return finalMax < 0 ? -1 : finalMax % MOD;
};