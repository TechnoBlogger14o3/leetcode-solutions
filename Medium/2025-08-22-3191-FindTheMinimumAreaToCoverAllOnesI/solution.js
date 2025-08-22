/**
 * @param {number[][]} grid
 * @return {number}
 */
var minimumArea = function(grid) {
    if (!grid || grid.length === 0) return 0;
    
    const m = grid.length;
    const n = grid[0].length;
    
    // Find the boundaries of all 1's
    let minRow = m, maxRow = -1;
    let minCol = n, maxCol = -1;
    let hasOnes = false;
    
    // Scan the matrix to find the boundaries
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                hasOnes = true;
                minRow = Math.min(minRow, i);
                maxRow = Math.max(maxRow, i);
                minCol = Math.min(minCol, j);
                maxCol = Math.max(maxCol, j);
            }
        }
    }
    
    // If no 1's found, return 0
    if (!hasOnes) return 0;
    
    // Calculate area: (maxRow - minRow + 1) * (maxCol - minCol + 1)
    const height = maxRow - minRow + 1;
    const width = maxCol - minCol + 1;
    
    return height * width;
};
