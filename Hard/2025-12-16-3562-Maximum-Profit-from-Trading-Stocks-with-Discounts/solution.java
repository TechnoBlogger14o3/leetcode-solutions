import java.util.*;

public class Solution {
    public int maximumProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : hierarchy) {
            graph.get(edge[0]).add(edge[1]);
        }

        int[] profits = new int[n + 1];
        int[] costs = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            profits[i] = future[i - 1] - present[i - 1];
            costs[i] = present[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int child : graph.get(i)) {
                costs[child] = Math.min(costs[child], present[child - 1] / 2);
            }
        }

        int[][] dp = new int[n + 1][budget + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= budget; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= costs[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - costs[i]] + profits[i]);
                }
            }
        }

        return dp[n][budget];
    }
}