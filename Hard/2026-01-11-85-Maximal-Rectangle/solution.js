var maximalRectangle = function(matrix) {
    if (matrix.length === 0) return 0;
    
    const rows = matrix.length;
    const cols = matrix[0].length;
    const heights = Array(cols).fill(0);
    let maxArea = 0;

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            heights[j] = matrix[i][j] === '1' ? heights[j] + 1 : 0;
        }
        maxArea = Math.max(maxArea, largestRectangleArea(heights));
    }

    return maxArea;
};

function largestRectangleArea(heights) {
    const stack = [];
    let maxArea = 0;
    heights.push(0); // Add a sentinel value

    for (let i = 0; i < heights.length; i++) {
        while (stack.length && heights[stack[stack.length - 1]] > heights[i]) {
            const h = heights[stack.pop()];
            const w = stack.length ? i - stack[stack.length - 1] - 1 : i;
            maxArea = Math.max(maxArea, h * w);
        }
        stack.push(i);
    }

    return maxArea;
}