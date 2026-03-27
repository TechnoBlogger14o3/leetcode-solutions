function matrixSimilarity(mat, k) {
    const m = mat.length;
    const n = mat[0].length;

    const shiftRow = (row, isEven) => {
        const shift = isEven ? k % n : n - (k % n);
        return [...row.slice(shift), ...row.slice(0, shift)];
    };

    const transformedMatrix = mat.map((row, index) => shiftRow(row, index % 2 === 0));

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (transformedMatrix[i][j] !== mat[i][j]) {
                return false;
            }
        }
    }
    return true;
}