class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean[][] visited;
    private boolean[][] inPath;
    private int m, n;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        inPath = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && dfs(grid, i, j, -1, -1, grid[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int x, int y, int fromX, int fromY, char target) {
        visited[x][y] = true;
        inPath[x][y] = true;

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == target) {
                if ((newX == fromX && newY == fromY)) {
                    continue; // Skip the cell we just came from
                }
                if (inPath[newX][newY] || (!visited[newX][newY] && dfs(grid, newX, newY, x, y, target))) {
                    return true;
                }
            }
        }

        inPath[x][y] = false;
        return false;
    }
}