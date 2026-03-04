var numSpecial = function(mat) {
    const m = mat.length;
    const n = mat[0].length;
    const rowCount = new Array(m).fill(0);
    const colCount = new Array(n).fill(0);
    
    // Count the number of 1s in each row and column
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (mat[i][j] === 1) {
                rowCount[i]++;
                colCount[j]++;
            }
        }
    }
    
    let specialCount = 0;
    
    // Count special positions
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (mat[i][j] === 1 && rowCount[i] === 1 && colCount[j] === 1) {
                specialCount++;
            }
        }
    }
    
    return specialCount;
};