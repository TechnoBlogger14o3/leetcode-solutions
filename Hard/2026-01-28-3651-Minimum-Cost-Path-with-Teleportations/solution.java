import java.util.*;

public class Solution {
    public int minCostPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        dp[0][0][k] = 0;
        
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new State(0, 0, k, 0));
        
        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int x = curr.x, y = curr.y, remainingK = curr.remainingK, cost = curr.cost;
            
            if (x == m - 1 && y == n - 1) {
                return cost;
            }
            
            // Normal moves
            if (x + 1 < m) {
                int newCost = cost + grid[x + 1][y];
                if (newCost < dp[x + 1][y][remainingK]) {
                    dp[x + 1][y][remainingK] = newCost;
                    pq.offer(new State(x + 1, y, remainingK, newCost));
                }
            }
            if (y + 1 < n) {
                int newCost = cost + grid[x][y + 1];
                if (newCost < dp[x][y + 1][remainingK]) {
                    dp[x][y + 1][remainingK] = newCost;
                    pq.offer(new State(x, y + 1, remainingK, newCost));
                }
            }
            
            // Teleportation
            if (remainingK > 0) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] <= grid[x][y]) {
                            if (cost < dp[i][j][remainingK - 1]) {
                                dp[i][j][remainingK - 1] = cost;
                                pq.offer(new State(i, j, remainingK - 1, cost));
                            }
                        }
                    }
                }
            }
        }
        
        return -1; // Should never reach here if input constraints are followed
    }
    
    private static class State {
        int x, y, remainingK, cost;
        
        State(int x, int y, int remainingK, int cost) {
            this.x = x;
            this.y = y;
            this.remainingK = remainingK;
            this.cost = cost;
        }
    }
}