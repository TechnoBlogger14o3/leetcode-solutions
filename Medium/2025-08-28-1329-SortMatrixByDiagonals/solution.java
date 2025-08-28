import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        // Sort diagonals starting from top row (excluding main diagonal)
        for (int d = n - 2; d >= 0; d--) {
            List<Integer> diag = new ArrayList<>();
            for (int i = 0; i < n - d; i++) {
                diag.add(grid[i][i + d]);
            }
            Collections.sort(diag);
            for (int i = 0; i < n - d; i++) {
                grid[i][i + d] = diag.get(i);
            }
        }
        
        // Sort diagonals starting from left column (including main diagonal)
        for (int d = 0; d < n; d++) {
            List<Integer> diag = new ArrayList<>();
            for (int j = 0; j < n - d; j++) {
                diag.add(grid[j + d][j]);
            }
            Collections.sort(diag, Collections.reverseOrder());
            for (int j = 0; j < n - d; j++) {
                grid[j + d][j] = diag.get(j);
            }
        }
        
        return grid;
    }
}
