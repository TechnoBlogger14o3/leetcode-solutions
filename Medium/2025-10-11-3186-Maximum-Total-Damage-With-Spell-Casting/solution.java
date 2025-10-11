import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long maxDamage(int[] power) {
        Map<Integer, Long> damageMap = new HashMap<>();
        
        for (int p : power) {
            damageMap.put(p, damageMap.getOrDefault(p, 0L) + p);
        }
        
        long[] dp = new long[100001];
        
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + damageMap.getOrDefault(i, 0L));
        }
        
        return dp[100000];
    }
}