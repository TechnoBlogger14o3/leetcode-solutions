/**
 * @param {number[][]} grid
 * @return {number}
 */
var minimumSum = function(grid) {
    
    function boundingBoxArea(grid, u, d, l, r) {
        let minRow = grid.length, maxRow = -1;
        let minCol = grid[0].length, maxCol = -1;

        for (let i = u; i <= d; i++) {
            for (let j = l; j <= r; j++) {
                if (grid[i][j] === 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        // If no 1's is found, return "infinite" cost so this partition is invalid
        if (maxRow === -1) {
            return Number.MAX_SAFE_INTEGER / 3;
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    function solve(grid) {
        const n = grid.length;
        const m = grid[0].length;
        let best = n * m;
        
        // Case 1: L- shaped partitions
        for (let row = 0; row + 1 < n; row++) {
            for (let col = 0; col + 1 < m; col++) {
                // Top + Bottom - left + Bottom - right
                const area1 = boundingBoxArea(grid, 0, row, 0, m - 1) + 
                             boundingBoxArea(grid, row + 1, n - 1, 0, col) +
                             boundingBoxArea(grid, row + 1, n - 1, col + 1, m - 1);

                // top-left + top-right + bottom
                const area2 = boundingBoxArea(grid, 0, row, 0, col) + 
                             boundingBoxArea(grid, 0, row, col + 1, m - 1) +
                             boundingBoxArea(grid, row + 1, n - 1, 0, m - 1);

                best = Math.min(best, Math.min(area1, area2));
            }
        }

        // Case 2: Three horizontal strips
        for (let r1 = 0; r1 + 2 < n; r1++) {
            for (let r2 = r1 + 1; r2 + 1 < n; r2++) {
                const area = boundingBoxArea(grid, 0, r1, 0, m - 1) + 
                            boundingBoxArea(grid, r1 + 1, r2, 0, m - 1) +
                            boundingBoxArea(grid, r2 + 1, n - 1, 0, m - 1);
                best = Math.min(best, area);
            }
        }
        return best;
    }

    function rotate90(grid) {
        const n = grid.length;
        const m = grid[0].length;
        const rotated = Array(m).fill().map(() => Array(n).fill(0));

        for (let i = 0; i < n; i++) {
            for (let j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = grid[i][j];
                }
            }
        return rotated;
    }

    const rotated = rotate90(grid);
    return Math.min(solve(grid), solve(rotated));
};
