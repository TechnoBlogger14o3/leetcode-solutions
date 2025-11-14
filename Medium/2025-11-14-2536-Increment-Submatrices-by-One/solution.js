var incrementSubmatrices = function(n, queries) {
    const mat = Array.from({ length: n }, () => Array(n).fill(0));

    for (const [row1, col1, row2, col2] of queries) {
        for (let i = row1; i <= row2; i++) {
            for (let j = col1; j <= col2; j++) {
                mat[i][j]++;
            }
        }
    }

    return mat;
};