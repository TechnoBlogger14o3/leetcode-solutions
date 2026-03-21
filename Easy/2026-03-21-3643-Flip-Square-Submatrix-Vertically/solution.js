function flipVertical(grid, x, y, k) {
    for (let i = 0; i < Math.floor(k / 2); i++) {
        for (let j = 0; j < k; j++) {
            const temp = grid[x + i][y + j];
            grid[x + i][y + j] = grid[x + k - 1 - i][y + j];
            grid[x + k - 1 - i][y + j] = temp;
        }
    }
    return grid;
}