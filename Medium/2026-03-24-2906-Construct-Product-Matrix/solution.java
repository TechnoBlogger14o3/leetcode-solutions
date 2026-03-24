class Solution {
    public int[][] construct2DArray(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        long totalProduct = 1;
        int zeroCount = 0;

        for (int[] row : grid) {
            for (int num : row) {
                if (num == 0) {
                    zeroCount++;
                } else {
                    totalProduct = (totalProduct * num) % 12345;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (zeroCount > 1) {
                    result[i][j] = 0;
                } else if (zeroCount == 1) {
                    result[i][j] = grid[i][j] == 0 ? (int)(totalProduct % 12345) : 0;
                } else {
                    result[i][j] = (int)((totalProduct * modInverse(grid[i][j], 12345)) % 12345);
                }
            }
        }

        return result;
    }

    private long modInverse(int a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private long pow(int base, int exp, int mod) {
        long result = 1;
        long b = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }
        return result;
    }
}