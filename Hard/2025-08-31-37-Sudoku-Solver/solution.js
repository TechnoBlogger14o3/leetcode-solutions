var solveSudoku = function(board) {
    const isValid = (row, col, num) => {
        const boxRow = Math.floor(row / 3) * 3;
        const boxCol = Math.floor(col / 3) * 3;
        for (let i = 0; i < 9; i++) {
            if (board[row][i] === num || board[i][col] === num || board[boxRow + Math.floor(i / 3)][boxCol + (i % 3)] === num) {
                return false;
            }
        }
        return true;
    };

    const solve = () => {
        for (let row = 0; row < 9; row++) {
            for (let col = 0; col < 9; col++) {
                if (board[row][col] === '.') {
                    for (let num = 1; num <= 9; num++) {
                        const strNum = num.toString();
                        if (isValid(row, col, strNum)) {
                            board[row][col] = strNum;
                            if (solve()) {
                                return true;
                            }
                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // solved
    };

    solve();
};