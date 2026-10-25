class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int closedIslands = 0;

        // Flood fill to mark the boundary connected lands
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && (i == 0 || i == rows - 1 || j == 0 || j == cols - 1)) {
                    floodFill(grid, i, j);
                }
            }
        }

        // Count closed islands
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    closedIslands++;
                    floodFill(grid, i, j);
                }
            }
        }

        return closedIslands;
    }

    private void floodFill(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 0) {
            return;
        }
        grid[x][y] = 1; // Mark as visited
        floodFill(grid, x + 1, y);
        floodFill(grid, x - 1, y);
        floodFill(grid, x, y + 1);
        floodFill(grid, x, y - 1);
    }
}