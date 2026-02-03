class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        // Find the peak of the first increasing sequence
        int p = 0;
        while (p + 1 < n && nums[p] < nums[p + 1]) {
            p++;
        }

        // If p is at the start or end, return false
        if (p == 0 || p == n - 1) return false;

        // Find the peak of the decreasing sequence
        int q = p;
        while (q + 1 < n && nums[q] > nums[q + 1]) {
            q++;
        }

        // If q is at the end, return false
        if (q == n - 1) return false;

        // Check if the last part is strictly increasing
        for (int i = q; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}