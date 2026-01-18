var largestMagicSquare = function(grid) {
    const m = grid.length, n = grid[0].length;
    const dp = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));
    let maxSize = 1;

    for (let i = m - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            dp[i][j] = 1; // At least the cell itself is a magic square
            if (i + 1 < m && j + 1 < n) {
                let size = 1;
                while (size <= Math.min(m - i, n - j)) {
                    let rowSum = 0, colSum = 0, diag1 = 0, diag2 = 0;
                    let valid = true;
                    for (let k = 0; k < size; k++) {
                        rowSum += grid[i + size - 1][j + k];
                        colSum += grid[i + k][j + size - 1];
                        if (k === 0) {
                            diag1 = grid[i + k][j + k];
                            diag2 = grid[i + k][j + size - 1 - k];
                        } else {
                            diag1 += grid[i + k][j + k];
                            diag2 += grid[i + k][j + size - 1 - k];
                        }
                    }
                    if (rowSum !== colSum || rowSum !== diag1 || rowSum !== diag2) {
                        valid = false;
                    }
                    if (valid) {
                        dp[i][j] = size + 1;
                        maxSize = Math.max(maxSize, dp[i][j]);
                    } else {
                        break;
                    }
                    size++;
                }
            }
        }
    }
    return maxSize;
};