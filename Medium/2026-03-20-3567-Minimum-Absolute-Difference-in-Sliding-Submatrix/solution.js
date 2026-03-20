var minAbsDiffInSubmatrix = function(grid, k) {
    const m = grid.length;
    const n = grid[0].length;
    const ans = Array.from({ length: m - k + 1 }, () => Array(n - k + 1).fill(0));

    for (let i = 0; i <= m - k; i++) {
        for (let j = 0; j <= n - k; j++) {
            const values = new Set();
            for (let x = i; x < i + k; x++) {
                for (let y = j; y < j + k; y++) {
                    values.add(grid[x][y]);
                }
            }
            const sortedValues = Array.from(values).sort((a, b) => a - b);
            let minDiff = Infinity;

            for (let l = 1; l < sortedValues.length; l++) {
                minDiff = Math.min(minDiff, sortedValues[l] - sortedValues[l - 1]);
            }

            ans[i][j] = minDiff === Infinity ? 0 : minDiff;
        }
    }

    return ans;
};