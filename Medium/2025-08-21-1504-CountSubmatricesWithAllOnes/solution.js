/**
 * @param {number[][]} mat
 * @return {number}
 */
var numSubmat = function(mat) {
    if (!mat || mat.length === 0) return 0;
    
    const m = mat.length;
    const n = mat[0].length;
    let count = 0;
    
    // For each row, calculate the number of consecutive 1s ending at each position
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (mat[i][j] === 1) {
                // Count submatrices ending at current position
                count += countSubmatricesAt(mat, i, j);
            }
        }
    }
    
    return count;
};

function countSubmatricesAt(mat, row, col) {
    let count = 0;
    let maxWidth = Infinity;
    
    // Try different heights starting from current row
    for (let height = 0; row - height >= 0; height++) {
        let consecutiveOnes = 0;
        
        // Count consecutive 1s in current row
        for (let j = col; j >= 0 && mat[row - height][j] === 1; j--) {
            consecutiveOnes++;
        }
        
        // Update maxWidth to be the minimum of all rows in current height
        maxWidth = Math.min(maxWidth, consecutiveOnes);
        
        // Add count for current height and width
        count += maxWidth;
    }
    
    return count;
}
