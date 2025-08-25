/**
 * @param {number[][]} mat
 * @return {number[]}
 */
var findDiagonalOrder = function(mat) {
    if (!mat || mat.length === 0) return [];
    
    const m = mat.length;
    const n = mat[0].length;
    
    // Map to group elements by diagonal sum
    const diagonals = new Map();
    
    // Group elements by diagonal sum (row + col)
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            const diagonalSum = i + j;
            if (!diagonals.has(diagonalSum)) {
                diagonals.set(diagonalSum, []);
            }
            diagonals.get(diagonalSum).push(mat[i][j]);
        }
    }
    
    // Build result array
    const result = [];
    
    // Process diagonals in order
    for (let diagonalSum = 0; diagonalSum <= m + n - 2; diagonalSum++) {
        const diagonal = diagonals.get(diagonalSum);
        if (diagonal) {
            // Even diagonals go from bottom-left to top-right (reverse order)
            // Odd diagonals go from top-left to bottom-right (normal order)
            if (diagonalSum % 2 === 0) {
                // Reverse for even diagonals
                for (let i = diagonal.length - 1; i >= 0; i--) {
                    result.push(diagonal[i]);
                }
            } else {
                // Normal order for odd diagonals
                for (const num of diagonal) {
                    result.push(num);
                }
            }
        }
    }
    
    return result;
};
