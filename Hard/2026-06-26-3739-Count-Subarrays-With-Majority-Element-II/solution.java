class Solution {
    public int countSubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        int targetCount = 0;
        int totalCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                targetCount++;
            } else {
                targetCount = 0;
            }

            int left = targetCount;
            int right = (i + 1) - (targetCount + 1);
            count += Math.max(0, left - right);
            totalCount += left;
        }

        return count;
    }
}