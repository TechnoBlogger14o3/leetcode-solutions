class Solution {
    public int[][] shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        int[][] result = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newIndex = (i * n + j + k) % (m * n);
                result[newIndex / n][newIndex % n] = grid[i][j];
            }
        }
        
        return result;
    }
}