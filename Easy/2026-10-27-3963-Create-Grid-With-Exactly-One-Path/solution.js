var createGrid = function(m, n) {
    const grid = Array.from({ length: m }, () => Array(n).fill('#'));
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (i + j === 0 || i + j === m + n - 2) {
                grid[i][j] = '.';
            } else if (i === m - 1 && j < n - 1) {
                grid[i][j] = '.';
            } else if (j === n - 1 && i < m - 1) {
                grid[i][j] = '.';
            }
        }
    }
    
    return grid.map(row => row.join(''));
};