import java.util.*;

class Solution {
    public int countPartitions(int[] nums, int k) {
        int mod = 1000000007;
        int n = nums.length;
        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: one way to partition an empty array
        
        for (int i = 1; i <= n; i++) {
            long count = 0;
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;
            for (int j = i; j >= 1; j--) {
                minVal = Math.min(minVal, nums[j - 1]);
                maxVal = Math.max(maxVal, nums[j - 1]);
                if (maxVal - minVal > k) break; // Stop if the condition is violated
                count = (count + dp[j - 1]) % mod; // Add the number of ways to partition up to j-1
            }
            dp[i] = count;
        }
        
        return (int) dp[n];
    }
}