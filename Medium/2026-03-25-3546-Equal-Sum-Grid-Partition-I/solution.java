class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int totalSum = 0;

        // Calculate total sum of the grid
        for (int[] row : grid) {
            for (int num : row) {
                totalSum += num;
            }
        }

        // Check for horizontal cuts
        int rowSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int num : grid[i]) {
                rowSum += num;
            }
            if (rowSum * 2 == totalSum) {
                return true;
            }
        }

        // Check for vertical cuts
        int[] colSums = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSums[j] += grid[i][j];
            }
        }

        int colSum = 0;
        for (int j = 0; j < n - 1; j++) {
            colSum += colSums[j];
            if (colSum * 2 == totalSum) {
                return true;
            }
        }

        return false;
    }
}