import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minOperations = Integer.MAX_VALUE;

        for (int i = 0; i <= n - x * k; i++) {
            int[] counts = new int[2000001];
            for (int j = 0; j < k; j++) {
                int start = i + j * x;
                int end = start + x;
                for (int m = start; m < end; m++) {
                    counts[nums[m] + 1000000]++;
                }
            }

            for (int j = 0; j < counts.length; j++) {
                if (counts[j] > 0) {
                    int target = j - 1000000;
                    int operations = 0;
                    for (int j2 = 0; j2 < k; j2++) {
                        int start = i + j2 * x;
                        int end = start + x;
                        for (int m = start; m < end; m++) {
                            operations += Math.abs(nums[m] - target);
                        }
                    }
                    minOperations = Math.min(minOperations, operations);
                }
            }
        }

        return minOperations;
    }
}