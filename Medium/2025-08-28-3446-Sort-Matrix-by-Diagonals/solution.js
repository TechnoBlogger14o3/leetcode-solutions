javascript
function diagonalSort(grid) {
    const n = grid.length;
    const bottomLeftDiagonals = {};
    const topRightDiagonals = {};

    // Collect bottom-left triangle diagonals
    for (let i = 0; i < n; i++) {
        for (let j = 0; j <= i; j++) {
            const key = i - j;
            if (!bottomLeftDiagonals[key]) {
                bottomLeftDiagonals[key] = [];
            }
            bottomLeftDiagonals[key].push(grid[i][j]);
        }
    }

    // Collect top-right triangle diagonals
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            const key = j - i;
            if (!topRightDiagonals[key]) {
                topRightDiagonals[key] = [];
            }
            topRightDiagonals[key].push(grid[i][j]);
        }
    }

    // Sort bottom-left diagonals in non-increasing order
    for (const key in bottomLeftDiagonals) {
        bottomLeftDiagonals[key].sort((a, b) => b - a);
    }

    // Sort top-right diagonals in non-decreasing order
    for (const key in topRightDiagonals) {
        topRightDiagonals[key].sort((a, b) => a - b);
    }

    // Reassign sorted values back to the grid
    for (let i = 0; i < n; i++) {
        for (let j = 0; j <= i; j++) {
            const key = i - j;
            grid[i][j] = bottomLeftDiagonals[key].shift();
        }
    }

    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            const key = j - i;
            grid[i][j] = topRightDiagonals[key].shift();
        }
    }

    return grid;
}