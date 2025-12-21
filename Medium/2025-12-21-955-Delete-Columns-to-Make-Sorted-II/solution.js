var minDeletionSize = function(strs) {
    let deleteCount = 0;
    const n = strs.length;
    const m = strs[0].length;
    const toDelete = new Array(m).fill(false);

    for (let col = 0; col < m; col++) {
        for (let row = 1; row < n; row++) {
            if (toDelete[col]) break;
            if (strs[row][col] < strs[row - 1][col]) {
                toDelete[col] = true;
                deleteCount++;
                break;
            }
        }
    }

    return deleteCount;
};