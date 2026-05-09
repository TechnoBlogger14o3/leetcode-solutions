var rotateGrid = function(grid, k) {
    const m = grid.length, n = grid[0].length;
    const layers = Math.min(m, n) / 2;

    for (let layer = 0; layer < layers; layer++) {
        const elements = [];
        const rowStart = layer, rowEnd = m - layer - 1;
        const colStart = layer, colEnd = n - layer - 1;

        // Collect the elements of the current layer
        for (let col = colStart; col <= colEnd; col++) elements.push(grid[rowStart][col]);
        for (let row = rowStart + 1; row <= rowEnd; row++) elements.push(grid[row][colEnd]);
        for (let col = colEnd - 1; col >= colStart; col--) elements.push(grid[rowEnd][col]);
        for (let row = rowEnd - 1; row > rowStart; row--) elements.push(grid[row][colStart]);

        const len = elements.length;
        const effectiveK = k % len;

        // Rotate the elements
        const rotated = [...elements.slice(len - effectiveK), ...elements.slice(0, len - effectiveK)];

        // Place the rotated elements back into the grid
        let index = 0;
        for (let col = colStart; col <= colEnd; col++) grid[rowStart][col] = rotated[index++];
        for (let row = rowStart + 1; row <= rowEnd; row++) grid[row][colEnd] = rotated[index++];
        for (let col = colEnd - 1; col >= colStart; col--) grid[rowEnd][col] = rotated[index++];
        for (let row = rowEnd - 1; row > rowStart; row--) grid[row][colStart] = rotated[index++];
    }

    return grid;
};