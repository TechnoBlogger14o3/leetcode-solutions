/**
 * @param {number[][]} grid
 * @return {number[][]}
 */
var sortMatrix = function(grid) {
    const n = grid.length;
    
    // Sort diagonals starting from top row (excluding main diagonal)
    for (let d = n - 2; d >= 0; d--) {
        const diag = [];
        for (let i = 0; i < n - d; i++) {
            diag.push(grid[i][i + d]);
        }
        diag.sort((a, b) => a - b);
        for (let i = 0; i < n - d; i++) {
            grid[i][i + d] = diag[i];
        }
    }
    
    // Sort diagonals starting from left column (including main diagonal)
    for (let d = 0; d < n; d++) {
        const diag = [];
        for (let i = 0; i < n - d; i++) {
            diag.push(grid[i + d][i]);
        }
        diag.sort((a, b) => b - a); // reverse sort
        for (let i = 0; i < n - d; i++) {
            grid[i + d][i] = diag[i];
        }
    }
    
    return grid;
};
