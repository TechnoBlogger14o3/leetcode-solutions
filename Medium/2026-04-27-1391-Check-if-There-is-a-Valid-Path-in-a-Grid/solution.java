import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            if (x == m - 1 && y == n - 1) {
                return true;
            }

            for (int[] direction : getDirections(grid[x][y])) {
                int newX = x + direction[0], newY = y + direction[1];
                if (isValid(newX, newY, m, n, visited, grid)) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return false;
    }

    private boolean isValid(int x, int y, int m, int n, boolean[][] visited, int[][] grid) {
        return x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && canConnect(grid, x, y);
    }

    private boolean canConnect(int[][] grid, int x, int y) {
        int cellType = grid[x][y];
        if (cellType == 1) return true; // left-right
        if (cellType == 2) return true; // up-down
        if (cellType == 3) return x > 0 && grid[x - 1][y] == 2; // left-down
        if (cellType == 4) return x < grid.length - 1 && grid[x + 1][y] == 2; // right-down
        if (cellType == 5) return y > 0 && grid[x][y - 1] == 1; // left-up
        if (cellType == 6) return y < grid[0].length - 1 && grid[x][y + 1] == 1; // right-up
        return false;
    }

    private int[][] getDirections(int cellType) {
        switch (cellType) {
            case 1: return new int[][]{{0, 1}, {0, -1}}; // left-right
            case 2: return new int[][]{{1, 0}, {-1, 0}}; // up-down
            case 3: return new int[][]{{0, -1}, {1, 0}}; // left-down
            case 4: return new int[][]{{0, 1}, {1, 0}}; // right-down
            case 5: return new int[][]{{0, -1}, {-1, 0}}; // left-up
            case 6: return new int[][]{{0, 1}, {-1, 0}}; // right-up
            default: return new int[0][0];
        }
    }
}