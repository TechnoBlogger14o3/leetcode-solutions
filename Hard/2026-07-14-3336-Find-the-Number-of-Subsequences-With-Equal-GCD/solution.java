import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1000000007;

    public int countSubsequences(int[] nums) {
        int n = nums.length;
        Map<Integer, Long> countMap = new HashMap<>();
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0L) + 1);
        }

        long result = 0;

        for (int g = 1; g <= 200; g++) {
            long totalCount = 0;
            for (int multiple = g; multiple <= 200; multiple += g) {
                totalCount = (totalCount + countMap.getOrDefault(multiple, 0L)) % MOD;
            }
            if (totalCount > 0) {
                long pairs = (pow2[(int) totalCount] - 1 + MOD) % MOD;
                result = (result + pairs * pairs) % MOD;
            }
        }

        return (int) result;
    }
}