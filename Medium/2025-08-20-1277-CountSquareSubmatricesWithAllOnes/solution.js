/**
 * @param {number[][]} matrix
 * @return {number}
 */
var countSquares = function(matrix) {
    if (!matrix || matrix.length === 0) return 0;
    
    const m = matrix.length;
    const n = matrix[0].length;
    const dp = Array(m).fill().map(() => Array(n).fill(0));
    let count = 0;
    
    // Fill first row
    for (let j = 0; j < n; j++) {
        dp[0][j] = matrix[0][j];
        count += dp[0][j];
    }
    
    // Fill first column
    for (let i = 1; i < m; i++) {
        dp[i][0] = matrix[i][0];
        count += dp[i][0];
    }
    
    // Fill rest of the dp table
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            if (matrix[i][j] === 1) {
                // dp[i][j] = min of left, top, and top-left + 1
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                count += dp[i][j];
            }
        }
    }
    
    return count;
};
