import java.util.Arrays;

public class Solution {
    public long minimumTotalDistance(int[] robot, int[][] factory) {
        Arrays.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
        long totalDistance = 0;
        int n = robot.length;
        int m = factory.length;
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int[] f : factory) {
            int position = f[0];
            int limit = f[1];
            int[] newDp = Arrays.copyOf(dp, n + 1);
            
            for (int i = 0; i <= n; i++) {
                for (int j = 1; j <= limit && i + j <= n; j++) {
                    newDp[i + j] = Math.min(newDp[i + j], dp[i] + j * Math.abs(robot[i + j - 1] - position));
                }
            }
            dp = newDp;
        }
        
        return dp[n];
    }
}