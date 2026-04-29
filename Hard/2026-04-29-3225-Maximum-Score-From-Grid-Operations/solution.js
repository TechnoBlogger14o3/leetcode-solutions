var maximumScore = function(grid) {
    const n = grid.length;
    let maxScore = 0;

    for (let j = 0; j < n; j++) {
        let maxRow = -1;
        for (let i = 0; i < n; i++) {
            if (grid[i][j] > 0) {
                maxRow = i;
            }
        }
        if (maxRow !== -1) {
            for (let i = 0; i <= maxRow; i++) {
                for (let k = 0; k < n; k++) {
                    if (k !== j && grid[i][k] > 0) {
                        maxScore += grid[i][k];
                    }
                }
            }
            maxScore += grid[maxRow][j];
        }
    }

    return maxScore;
};