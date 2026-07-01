import java.util.*;

class Solution {
    public int maximumSafenessFactor(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize distances and queue with thieves' positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        // BFS to calculate minimum distance to any thief
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                    if (dist[newRow][newCol] > dist[cell[0]][cell[1]] + 1) {
                        dist[newRow][newCol] = dist[cell[0]][cell[1]] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        
        // Use binary search to find the maximum safeness factor
        int left = 0, right = n * 2; // Maximum possible distance
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canReachEnd(dist, mid)) {
                left = mid; // mid is possible
            } else {
                right = mid - 1; // mid is not possible
            }
        }
        
        return left;
    }
    
    private boolean canReachEnd(int[][] dist, int minSafeness) {
        int n = dist.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            if (cell[0] == n - 1 && cell[1] == n - 1) {
                return true; // Reached the end
            }
            for (int[] dir : directions) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol] && dist[newRow][newCol] >= minSafeness) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        return false; // Cannot reach the end
    }
}