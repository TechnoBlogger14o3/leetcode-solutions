var numMagicSquaresInside = function(grid) {
    const isMagicSquare = (square) => {
        const nums = new Set();
        let sum = 0;
        for (let i = 0; i < 3; i++) {
            sum += square[i][0];
            nums.add(square[i][0]);
            nums.add(square[i][1]);
            nums.add(square[i][2]);
        }
        for (let j = 0; j < 3; j++) {
            let colSum = square[0][j] + square[1][j] + square[2][j];
            if (colSum !== sum) return false;
        }
        const diag1 = square[0][0] + square[1][1] + square[2][2];
        const diag2 = square[0][2] + square[1][1] + square[2][0];
        if (diag1 !== sum || diag2 !== sum) return false;
        return nums.size === 9 && [...nums].every(num => num >= 1 && num <= 9);
    };

    let count = 0;
    const rows = grid.length;
    const cols = grid[0].length;

    for (let i = 0; i <= rows - 3; i++) {
        for (let j = 0; j <= cols - 3; j++) {
            const square = [
                [grid[i][j], grid[i][j + 1], grid[i][j + 2]],
                [grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2]],
                [grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2]]
            ];
            if (isMagicSquare(square)) {
                count++;
            }
        }
    }
    return count;
};