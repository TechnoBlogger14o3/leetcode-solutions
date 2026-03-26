class Solution {
    public boolean equalSumGridPartition(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int totalSum = 0;
        for (int[] row : grid) {
            for (int num : row) {
                totalSum += num;
            }
        }

        // Check horizontal cuts
        int[] rowSums = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += grid[i][j];
            }
        }

        int leftSum = 0;
        for (int i = 0; i < m - 1; i++) {
            leftSum += rowSums[i];
            int rightSum = totalSum - leftSum;
            if (leftSum == rightSum || leftSum + grid[i + 1][0] == rightSum || leftSum == rightSum + grid[i + 1][0]) {
                return true;
            }
        }

        // Check vertical cuts
        int[] colSums = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSums[j] += grid[i][j];
            }
        }

        leftSum = 0;
        for (int j = 0; j < n - 1; j++) {
            leftSum += colSums[j];
            int rightSum = totalSum - leftSum;
            if (leftSum == rightSum || leftSum + grid[0][j + 1] == rightSum || leftSum == rightSum + grid[0][j + 1]) {
                return true;
            }
        }

        return false;
    }
}