import java.util.Arrays;

class Solution {
    public int maxConsecutive(nums) {
        Arrays.sort(nums);
        int maxCount = 1;
        int currentCount = 1;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= 1) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;
    }
}