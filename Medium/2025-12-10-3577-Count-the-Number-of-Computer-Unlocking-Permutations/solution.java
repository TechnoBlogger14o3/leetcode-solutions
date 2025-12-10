import java.util.Arrays;

public class Solution {
    private static final int MOD = 1000000007;

    public int countOrders(int[] complexity) {
        int n = complexity.length;
        Arrays.sort(complexity);
        
        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: 1 way to unlock 0 computers
        
        for (int i = 1; i <= n; i++) {
            long count = 0;
            for (int j = 0; j < i; j++) {
                if (complexity[j] < complexity[i - 1]) {
                    count = (count + dp[j]) % MOD;
                }
            }
            dp[i] = count * factorial(i - 1) % MOD;
        }
        
        return (int) dp[n];
    }

    private long factorial(int x) {
        long result = 1;
        for (int i = 2; i <= x; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
}