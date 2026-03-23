class Solution {
    private static final int MOD = 1000000007;

    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] maxProd = new long[m][n];
        long[][] minProd = new long[m][n];

        maxProd[0][0] = grid[0][0];
        minProd[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                long maxVal = Long.MIN_VALUE;
                long minVal = Long.MAX_VALUE;

                if (i > 0) {
                    maxVal = Math.max(maxVal, maxProd[i - 1][j] * grid[i][j]);
                    minVal = Math.min(minVal, minProd[i - 1][j] * grid[i][j]);
                }
                if (j > 0) {
                    maxVal = Math.max(maxVal, maxProd[i][j - 1] * grid[i][j]);
                    minVal = Math.min(minVal, minProd[i][j - 1] * grid[i][j]);
                }

                maxProd[i][j] = maxVal;
                minProd[i][j] = minVal;
            }
        }

        long result = maxProd[m - 1][n - 1];
        return result < 0 ? -1 : (int) (result % MOD);
    }
}