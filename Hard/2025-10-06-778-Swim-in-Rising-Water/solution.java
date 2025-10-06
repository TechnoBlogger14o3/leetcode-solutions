import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int x = current[1];
            int y = current[2];

            if (x == n - 1 && y == n - 1) {
                return time;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    pq.offer(new int[]{Math.max(time, grid[newX][newY]), newX, newY});
                }
            }
        }
        return -1; // This line should never be reached
    }
}