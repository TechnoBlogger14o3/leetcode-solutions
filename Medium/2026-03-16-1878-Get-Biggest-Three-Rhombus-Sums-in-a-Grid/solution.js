var getBiggestThree = function(grid) {
    const m = grid.length, n = grid[0].length;
    const rhombusSums = new Set();

    const getRhombusSum = (x, y, d) => {
        let sum = 0;
        for (let i = 0; i <= d; i++) {
            sum += grid[x + i][y] || 0; // top
            sum += grid[x - i][y] || 0; // bottom
            if (i > 0) {
                sum += (grid[x + i][y + i] || 0) + (grid[x + i][y - i] || 0); // right and left
                sum += (grid[x - i][y + i] || 0) + (grid[x - i][y - i] || 0); // right and left
            }
        }
        return sum;
    };

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            for (let d = 0; d < Math.min(m, n); d++) {
                if (i - d >= 0 && i + d < m && j - d >= 0 && j + d < n) {
                    rhombusSums.add(getRhombusSum(i, j, d));
                } else {
                    break;
                }
            }
        }
    }

    const sortedSums = Array.from(rhombusSums).sort((a, b) => b - a);
    return sortedSums.slice(0, 3);
};