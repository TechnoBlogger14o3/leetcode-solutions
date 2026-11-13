class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long count = 0;
        int n = nums.length;
        int left = 0;
        long totalOperations = 0;

        for (int right = 0; right < n; right++) {
            if (right > 0 && nums[right] < nums[right - 1]) {
                totalOperations += (nums[right - 1] - nums[right]);
            }

            while (totalOperations > k) {
                if (left < right && nums[left] < nums[left + 1]) {
                    totalOperations -= (nums[left + 1] - nums[left]);
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}