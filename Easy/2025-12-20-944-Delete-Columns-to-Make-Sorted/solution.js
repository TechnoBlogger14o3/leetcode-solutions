var minDeletionSize = function(strs) {
    let count = 0;
    const numCols = strs[0].length;

    for (let col = 0; col < numCols; col++) {
        for (let row = 1; row < strs.length; row++) {
            if (strs[row][col] < strs[row - 1][col]) {
                count++;
                break;
            }
        }
    }

    return count;
};