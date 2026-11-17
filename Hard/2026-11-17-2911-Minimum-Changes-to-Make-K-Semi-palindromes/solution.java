import java.util.Arrays;

public class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int len = 1; len <= j; len++) {
                    int changes = calculateChanges(s.substring(j - len, j));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - len] + changes);
                }
            }
        }

        return dp[k][n];
    }

    private int calculateChanges(String substring) {
        int len = substring.length();
        int changes = 0;

        for (int d = 1; d <= len; d++) {
            if (len % d == 0) {
                int groups = len / d;
                int[] count = new int[26];
                for (int i = 0; i < d; i++) {
                    for (int j = i; j < len; j += d) {
                        count[substring.charAt(j) - 'a']++;
                    }
                }
                int groupChanges = 0;
                for (int c : count) {
                    groupChanges += c / 2;
                }
                changes = Math.min(changes, groups - groupChanges);
            }
        }

        return changes;
    }
}