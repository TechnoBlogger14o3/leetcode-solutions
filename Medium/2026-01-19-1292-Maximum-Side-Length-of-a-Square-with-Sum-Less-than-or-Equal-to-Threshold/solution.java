class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];

        // Calculate prefix sums
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = mat[i - 1][j - 1] 
                                 + prefixSum[i - 1][j] 
                                 + prefixSum[i][j - 1] 
                                 - prefixSum[i - 1][j - 1];
            }
        }

        int maxSide = 0;

        // Check for the maximum side length of the square
        for (int side = 1; side <= Math.min(m, n); side++) {
            for (int i = side; i <= m; i++) {
                for (int j = side; j <= n; j++) {
                    int total = prefixSum[i][j] 
                              - prefixSum[i - side][j] 
                              - prefixSum[i][j - side] 
                              + prefixSum[i - side][j - side];
                    if (total <= threshold) {
                        maxSide = side;
                    }
                }
            }
        }

        return maxSide;
    }
}