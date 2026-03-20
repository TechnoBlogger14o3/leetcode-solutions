import java.util.*;

public class Solution {
    public int[][] minimumAbsDifference(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                Set<Integer> distinctValues = new HashSet<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        distinctValues.add(grid[x][y]);
                    }
                }
                List<Integer> valuesList = new ArrayList<>(distinctValues);
                Collections.sort(valuesList);
                ans[i][j] = findMinAbsDifference(valuesList);
            }
        }
        return ans;
    }

    private int findMinAbsDifference(List<Integer> values) {
        if (values.size() < 2) return 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            minDiff = Math.min(minDiff, values.get(i) - values.get(i - 1));
        }
        return minDiff;
    }
}