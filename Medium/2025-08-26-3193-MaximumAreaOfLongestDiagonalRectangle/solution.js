/**
 * @param {number[][]} dimensions
 * @return {number}
 */
var areaOfMaxDiagonal = function(dimensions) {
    if (!dimensions || dimensions.length === 0) return 0;
    
    let maxDiagonal = 0;
    let maxArea = 0;
    
    for (const rect of dimensions) {
        const length = rect[0];
        const width = rect[1];
        
        // Calculate diagonal length using Pythagorean theorem
        const diagonal = Math.sqrt(length * length + width * width);
        
        // If this diagonal is longer, update both diagonal and area
        if (diagonal > maxDiagonal) {
            maxDiagonal = diagonal;
            maxArea = length * width;
        }
        // If diagonal is equal, keep the rectangle with larger area
        else if (Math.abs(diagonal - maxDiagonal) < 1e-9) {
            maxArea = Math.max(maxArea, length * width);
        }
    }
    
    return maxArea;
};
