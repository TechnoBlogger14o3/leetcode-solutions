import java.util.*;

public class Solution {
    public int minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        Map<String, List<int[]>> map = new HashMap<>();
        
        for (int i = 0; i < original.length; i++) {
            String key = original[i];
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new int[]{i, changed[i].length(), cost[i]});
        }
        
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                // Keep the same character
                if (source.charAt(i) == target.charAt(i)) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                }

                // Try to change substrings
                for (int k = 1; k <= n - i; k++) {
                    String subSource = source.substring(i, i + k);
                    String subTarget = target.substring(i, i + k);
                    if (subSource.equals(subTarget)) continue;

                    if (map.containsKey(subSource)) {
                        for (int[] entry : map.get(subSource)) {
                            int idx = entry[0];
                            String newTarget = changed[idx];
                            int changeCost = entry[2];

                            if (newTarget.equals(subTarget)) {
                                dp[i + k][i] = Math.min(dp[i + k][i], dp[i][j] + changeCost);
                            }
                        }
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++) {
            result = Math.min(result, dp[n][j]);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}