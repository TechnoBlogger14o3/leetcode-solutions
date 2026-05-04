var rotate = function(matrix) {
    const n = matrix.length;
    
    // First, transpose the matrix
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            [matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
        }
    }
    
    // Then, reverse each row
    for (let i = 0; i < n; i++) {
        matrix[i].reverse();
    }
};