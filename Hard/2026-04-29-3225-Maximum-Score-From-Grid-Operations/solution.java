class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long maxScore = 0;

        for (int j = 0; j < n; j++) {
            int maxRow = -1;
            long columnSum = 0;

            for (int i = 0; i < n; i++) {
                if (grid[i][j] > 0) {
                    columnSum += grid[i][j];
                    maxRow = i;
                }
            }

            if (maxRow != -1) {
                for (int i = 0; i <= maxRow; i++) {
                    for (int k = 0; k < n; k++) {
                        if (k != j && grid[i][k] > 0) {
                            maxScore += grid[i][k];
                        }
                    }
                }
                maxScore += columnSum;
            }
        }

        return maxScore;
    }
}