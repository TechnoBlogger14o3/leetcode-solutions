var rotateTheBox = function(boxGrid) {
    const m = boxGrid.length;
    const n = boxGrid[0].length;
    const result = Array.from({ length: n }, () => Array(m).fill('.'));

    for (let j = 0; j < n; j++) {
        let stones = 0;
        for (let i = m - 1; i >= 0; i--) {
            if (boxGrid[i][j] === '#') {
                stones++;
            } else if (boxGrid[i][j] === '*') {
                for (let k = 0; k < stones; k++) {
                    result[j][m - 1 - k] = '#';
                }
                stones = 0;
                result[j][i] = '*';
            }
        }
        for (let k = 0; k < stones; k++) {
            result[j][m - 1 - k] = '#';
        }
    }

    return result;
};