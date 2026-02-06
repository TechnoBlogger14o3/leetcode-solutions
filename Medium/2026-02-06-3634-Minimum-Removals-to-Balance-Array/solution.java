import java.util.Arrays;

class Solution {
    public int minimumRemovals(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = 0, minRemovals = n;

        while (right < n) {
            while (right < n && nums[right] <= nums[left] * k) {
                right++;
            }
            minRemovals = Math.min(minRemovals, n - (right - left));
            left++;
        }

        return minRemovals;
    }
}