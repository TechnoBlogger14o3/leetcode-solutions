class Solution {
    public int countIslandsWithTotalValueDivisibleByK(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int totalValue = dfs(grid, visited, i, j);
                    if (totalValue % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        int total = grid[i][j];
        total += dfs(grid, visited, i + 1, j);
        total += dfs(grid, visited, i - 1, j);
        total += dfs(grid, visited, i, j + 1);
        total += dfs(grid, visited, i, j - 1);
        return total;
    }
}