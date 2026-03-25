var canPartition = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    
    // Calculate total sum of the grid
    let totalSum = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            totalSum += grid[i][j];
        }
    }
    
    // Check for horizontal cuts
    let rowSum = 0;
    for (let i = 0; i < m - 1; i++) {
        rowSum += grid[i].reduce((a, b) => a + b, 0);
        if (rowSum * 2 === totalSum) {
            return true;
        }
    }
    
    // Check for vertical cuts
    let colSum = new Array(n).fill(0);
    for (let j = 0; j < n; j++) {
        for (let i = 0; i < m; i++) {
            colSum[j] += grid[i][j];
        }
    }
    
    let currentColSum = 0;
    for (let j = 0; j < n - 1; j++) {
        currentColSum += colSum[j];
        if (currentColSum * 2 === totalSum) {
            return true;
        }
    }
    
    return false;
};