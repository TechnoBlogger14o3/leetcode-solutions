function findRotation(mat, target) {
    const n = mat.length;

    const rotate = (matrix) => {
        const newMatrix = Array.from({ length: n }, () => Array(n).fill(0));
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                newMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }
        return newMatrix;
    };

    for (let i = 0; i < 4; i++) {
        if (JSON.stringify(mat) === JSON.stringify(target)) {
            return true;
        }
        mat = rotate(mat);
    }

    return false;
}