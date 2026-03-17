class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        
        // Build the heights matrix
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == 1) {
                    heights[i][j] = (i == 0) ? 1 : heights[i - 1][j] + 1;
                }
            }
        }
        
        int maxArea = 0;
        
        // Calculate the maximum area for each row
        for (int i = 0; i < m; i++) {
            int[] row = heights[i].clone();
            Arrays.sort(row);
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, row[j] * (j + 1));
            }
        }
        
        return maxArea;
    }
}