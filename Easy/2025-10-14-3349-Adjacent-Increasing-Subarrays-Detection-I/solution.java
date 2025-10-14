class Solution {
    public boolean canDetectAdjacentIncreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i <= n - 2 * k; i++) {
            if (isStrictlyIncreasing(nums, i, k) && isStrictlyIncreasing(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrictlyIncreasing(int[] nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}