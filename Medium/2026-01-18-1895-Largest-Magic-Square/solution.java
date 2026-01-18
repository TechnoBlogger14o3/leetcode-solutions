class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowSum = new int[m + 1][n + 1];
        int[][] colSum = new int[m + 1][n + 1];
        int[][] diagSum1 = new int[m + 1][n + 1];
        int[][] diagSum2 = new int[m + 1][n + 1];
        
        // Calculate prefix sums for rows, columns and diagonals
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i - 1][j - 1];
                colSum[i][j] = colSum[i - 1][j] + grid[i - 1][j - 1];
                if (i == j) {
                    diagSum1[i][j] = diagSum1[i - 1][j - 1] + grid[i - 1][j - 1];
                }
                if (i + j == n + 1) {
                    diagSum2[i][j] = diagSum2[i - 1][j + 1] + grid[i - 1][j - 1];
                }
            }
        }
        
        int maxSize = 1;
        
        // Check for the largest magic square
        for (int size = 2; size <= Math.min(m, n); size++) {
            for (int i = size; i <= m; i++) {
                for (int j = size; j <= n; j++) {
                    int sum = rowSum[i][j] - rowSum[i][j - size] - rowSum[i - size][j] + rowSum[i - size][j - size];
                    boolean isMagic = true;
                    
                    // Check rows and columns
                    for (int k = 0; k < size; k++) {
                        if (rowSum[i][j - k] - rowSum[i][j - k - size] != sum || 
                            colSum[i - k][j] - colSum[i - k - size][j] != sum) {
                            isMagic = false;
                            break;
                        }
                    }
                    
                    // Check diagonals
                    if (isMagic) {
                        if (diagSum1[i][j] - diagSum1[i - size][j - size] != sum || 
                            diagSum2[i][j] - diagSum2[i - size][j + size] != sum) {
                            isMagic = false;
                        }
                    }
                    
                    if (isMagic) {
                        maxSize = size;
                    }
                }
            }
        }
        
        return maxSize;
    }
}