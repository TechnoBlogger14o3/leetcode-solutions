class Solution {
    public int minimumArea(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        // Find the boundaries of all 1's
        int minRow = m, maxRow = -1;
        int minCol = n, maxCol = -1;
        boolean hasOnes = false;
        
        // Scan the matrix to find the boundaries
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hasOnes = true;
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        
        // If no 1's found, return 0
        if (!hasOnes) return 0;
        
        // Calculate area: (maxRow - minRow + 1) * (maxCol - minCol + 1)
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;
        
        return height * width;
    }
} 
