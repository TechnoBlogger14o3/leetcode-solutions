class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        int[] nums = new int[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nums[grid[row + i][col + j]]++;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (nums[i] != 1) return false;
        }
        return (grid[row][col] + grid[row][col + 1] + grid[row][col + 2] == 15) &&
               (grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2] == 15) &&
               (grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2] == 15) &&
               (grid[row][col] + grid[row + 1][col] + grid[row + 2][col] == 15) &&
               (grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1] == 15) &&
               (grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2] == 15) &&
               (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] == 15) &&
               (grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2] == 15);
    }
}