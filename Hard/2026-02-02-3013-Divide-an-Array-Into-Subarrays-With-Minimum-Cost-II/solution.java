import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public long minCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= k; i++) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                if (j >= dist) {
                    pq.offer(dp[j - dist]);
                }
                if (j >= i - 1) {
                    while (!pq.isEmpty() && pq.peek() == dp[j - (i - 1)]) {
                        pq.poll();
                    }
                    long cost = pq.isEmpty() ? Long.MAX_VALUE : pq.peek() + nums[j];
                    dp[j] = Math.min(dp[j], cost);
                }
            }
        }
        
        long result = Long.MAX_VALUE;
        for (int j = n - 1; j >= n - dist; j--) {
            if (j >= 0) {
                result = Math.min(result, dp[j]);
            }
        }
        
        return result;
    }
}