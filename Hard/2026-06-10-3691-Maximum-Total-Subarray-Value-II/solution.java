import java.util.*;

public class Solution {
    public long maximumTotalValue(int[] nums, int k) {
        int n = nums.length;
        long[] values = new long[n * (n + 1) / 2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                values[index++] = max - min;
            }
        }

        Arrays.sort(values);
        long totalValue = 0;
        for (int i = 0; i < k; i++) {
            totalValue += values[values.length - 1 - i];
        }

        return totalValue;
    }
}