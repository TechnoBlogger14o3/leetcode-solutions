var countNegatives = function(grid) {
    let count = 0;
    const m = grid.length;
    const n = grid[0].length;
    let row = m - 1;
    let col = 0;

    while (row >= 0 && col < n) {
        if (grid[row][col] < 0) {
            count += n - col;
            row--;
        } else {
            col++;
        }
    }

    return count;
};