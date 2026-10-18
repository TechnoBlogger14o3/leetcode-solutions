import java.util.HashMap;

public class Solution {
    private static final int MOD = 1000000007;
    private HashMap<Integer, Integer> factorials = new HashMap<>();

    public int numOfWays(int[] nums) {
        int n = nums.length;
        precomputeFactorials(n);
        return (int) (countWays(nums, 0, n - 1) - 1 + MOD) % MOD;
    }

    private long countWays(int[] nums, int start, int end) {
        if (start >= end) return 1;

        int root = nums[start];
        int leftCount = 0;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < root) leftCount++;
        }

        long leftWays = countWays(nums, start + 1, start + leftCount);
        long rightWays = countWays(nums, start + leftCount + 1, end);

        long totalWays = (leftWays * rightWays) % MOD;
        totalWays = (totalWays * factorials.get(leftCount + (end - start))) % MOD;
        totalWays = (totalWays * modInverse(factorials.get(leftCount))) % MOD;
        totalWays = (totalWays * modInverse(factorials.get(end - start))) % MOD;

        return totalWays;
    }

    private void precomputeFactorials(int n) {
        factorials.put(0, 1);
        for (int i = 1; i <= n; i++) {
            factorials.put(i, (int) ((factorials.get(i - 1) * (long) i) % MOD));
        }
    }

    private long modInverse(int a) {
        return power(a, MOD - 2);
    }

    private long power(int x, int y) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1;
        }
        return res;
    }
}