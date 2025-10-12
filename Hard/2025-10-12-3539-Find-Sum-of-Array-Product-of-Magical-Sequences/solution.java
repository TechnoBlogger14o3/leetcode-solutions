import java.util.*;

public class Solution {
    private static final int MOD = 1000000007;

    public int findSumOfArrayProduct(int m, int k, int[] nums) {
        int n = nums.length;
        long[][] dp = new long[m + 1][k + 1];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 1; j--) {
                for (int l = k; l >= 1; l--) {
                    dp[j][l] = (dp[j][l] + dp[j - 1][l - 1] * nums[i]) % MOD;
                }
            }
        }

        long result = 0;
        for (int j = 1; j <= m; j++) {
            result = (result + dp[j][k]) % MOD;
        }

        return (int) result;
    }
}