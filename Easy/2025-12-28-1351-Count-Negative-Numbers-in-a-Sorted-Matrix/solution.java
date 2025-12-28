class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int row = m - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                count += (n - col);
                row--;
            } else {
                col++;
            }
        }

        return count;
    }
}