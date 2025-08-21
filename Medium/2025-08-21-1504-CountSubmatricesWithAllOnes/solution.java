class Solution {
    public int numSubmat(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        
        // For each row, calculate the number of consecutive 1s ending at each position
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    // Count submatrices ending at current position
                    count += countSubmatricesAt(mat, i, j);
                }
            }
        }
        
        return count;
    }
    
    private int countSubmatricesAt(int[][] mat, int row, int col) {
        int count = 0;
        int maxWidth = Integer.MAX_VALUE;
        
        // Try different heights starting from current row
        for (int height = 0; row - height >= 0; height++) {
            int consecutiveOnes = 0;
            
            // Count consecutive 1s in current row
            for (int j = col; j >= 0 && mat[row - height][j] == 1; j--) {
                consecutiveOnes++;
            }
            
            // Update maxWidth to be the minimum of all rows in current height
            maxWidth = Math.min(maxWidth, consecutiveOnes);
            
            // Add count for current height and width
            count += maxWidth;
        }
        
        return count;
    }
}
