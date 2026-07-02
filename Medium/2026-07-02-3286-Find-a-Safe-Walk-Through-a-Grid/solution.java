import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean canWalkThrough(int[][] grid, int health) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, health}); // {row, col, remaining health}
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], remainingHealth = current[2];

            if (x == m - 1 && y == n - 1) {
                return remainingHealth > 0;
            }

            for (int[] dir : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    int newHealth = remainingHealth - grid[newX][newY];
                    if (newHealth > 0) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY, newHealth});
                    }
                }
            }
        }

        return false;
    }
}