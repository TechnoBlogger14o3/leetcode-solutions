import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int left = 0, right = 0, n = nums.length;
        long total = 0;
        int maxFreq = 0;

        while (right < n) {
            total += nums[right];
            while (nums[right] * (right - left + 1) - total > k * numOperations) {
                total -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
            right++;
        }

        return maxFreq;
    }
}