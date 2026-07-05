import java.util.*;

public class Solution {
    private static final int MOD = 1000000007;
    private int[][] dp;
    private int[][] count;
    private int rows, cols;

    public int[] pathsWithMaxScore(List<String> board) {
        rows = board.size();
        cols = board.get(0).length();
        dp = new int[rows][cols];
        count = new int[rows][cols];

        for (int[] row : dp) Arrays.fill(row, -1);
        for (int[] row : count) Arrays.fill(row, 0);

        dp[rows - 1][cols - 1] = 0;
        count[rows - 1][cols - 1] = 1;

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (board.get(r).charAt(c) == 'X') continue;
                if (r == rows - 1 && c == cols - 1) continue;

                int score = 0;
                if (board.get(r).charAt(c) != 'E') {
                    score = board.get(r).charAt(c) - '0';
                }

                for (int[] dir : new int[][]{{1, 0}, {0, 1}, {1, 1}}) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < rows && nc < cols && dp[nr][nc] != -1) {
                        if (dp[nr][nc] + score > dp[r][c]) {
                            dp[r][c] = dp[nr][nc] + score;
                            count[r][c] = count[nr][nc];
                        } else if (dp[nr][nc] + score == dp[r][c]) {
                            count[r][c] = (count[r][c] + count[nr][nc]) % MOD;
                        }
                    }
                }
            }
        }

        if (dp[0][0] == -1) return new int[]{0, 0};
        return new int[]{dp[0][0], count[0][0]};
    }
}