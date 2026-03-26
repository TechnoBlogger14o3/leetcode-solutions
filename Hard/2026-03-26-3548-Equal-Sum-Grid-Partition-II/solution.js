var equalSumGridPartition = function(grid) {
    const m = grid.length;
    const n = grid[0].length;

    const totalSum = grid.flat().reduce((a, b) => a + b, 0);
    
    const checkCut = (sum1, sum2) => {
        if (sum1 === sum2) return true;
        const diff = Math.abs(sum1 - sum2);
        return diff <= totalSum && (diff % 2 === 0);
    };

    // Check horizontal cuts
    let rowSum = 0;
    for (let i = 0; i < m - 1; i++) {
        rowSum += grid[i].reduce((a, b) => a + b, 0);
        const colSum = totalSum - rowSum;
        if (checkCut(rowSum, colSum)) return true;
    }

    // Check vertical cuts
    for (let j = 0; j < n; j++) {
        let colSum = 0;
        for (let i = 0; i < m; i++) {
            colSum += grid[i][j];
        }
        let remainingSum = totalSum - colSum;
        if (checkCut(colSum, remainingSum)) return true;
    }

    return false;
};