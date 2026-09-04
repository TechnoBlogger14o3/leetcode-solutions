class Solution {
    public int smallestStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        maxLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        minRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            int instabilityScore = maxLeft[i] - minRight[i];
            if (instabilityScore <= k) {
                return i;
            }
        }

        return -1;
    }
}