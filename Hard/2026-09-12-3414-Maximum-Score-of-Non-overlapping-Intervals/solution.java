import java.util.*;

public class Solution {
    public List<Integer> maximumScore(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[][] dp = new int[n + 1][5];
        int[][] prev = new int[n + 1][5];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 4; j++) {
                dp[i][j] = dp[i - 1][j];
                prev[i][j] = prev[i - 1][j];
                
                int weight = intervals[i - 1][2];
                int end = intervals[i - 1][1];
                
                for (int k = i - 1; k >= 0; k--) {
                    if (k == 0 || intervals[k - 1][1] < intervals[i - 1][0]) {
                        if (dp[k][j - 1] + weight > dp[i][j]) {
                            dp[i][j] = dp[k][j - 1] + weight;
                            prev[i][j] = k;
                        }
                        break;
                    }
                }
            }
        }
        
        int maxScore = 0;
        int maxIndex = 0;
        for (int j = 1; j <= 4; j++) {
            if (dp[n][j] > maxScore) {
                maxScore = dp[n][j];
                maxIndex = n;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int j = 4; j >= 1; j--) {
            while (maxIndex > 0 && prev[maxIndex][j] != maxIndex) {
                result.add(maxIndex - 1);
                maxIndex = prev[maxIndex][j];
                j--;
            }
        }
        
        Collections.sort(result);
        return result;
    }
}