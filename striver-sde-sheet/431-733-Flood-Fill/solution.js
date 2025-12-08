/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
var floodFill = function(image, sr, sc, color) {
    if (image[sr][sc] === color) {
        return image;
    }
    
    const originalColor = image[sr][sc];
    const rows = image.length;
    const cols = image[0].length;
    
    function dfs(r, c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] !== originalColor) {
            return;
        }
        
        image[r][c] = color;
        
        dfs(r + 1, c);
        dfs(r - 1, c);
        dfs(r, c + 1);
        dfs(r, c - 1);
    }
    
    dfs(sr, sc);
    return image;
};
