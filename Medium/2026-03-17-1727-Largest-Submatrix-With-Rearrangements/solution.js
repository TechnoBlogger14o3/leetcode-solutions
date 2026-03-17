var largestSubmatrix = function(matrix) {
    const m = matrix.length;
    const n = matrix[0].length;
    const heights = Array(n).fill(0);
    let maxArea = 0;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            heights[j] = matrix[i][j] === 0 ? 0 : heights[j] + 1;
        }
        
        const sortedHeights = [...heights].sort((a, b) => a - b);
        
        for (let j = 0; j < n; j++) {
            maxArea = Math.max(maxArea, sortedHeights[j] * (j + 1));
        }
    }
    
    return maxArea;
};