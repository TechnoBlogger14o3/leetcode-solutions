class Solution {
    public int minimumScore(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        int lowScore = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int newMin = Math.min(minNum, Math.min(nums[i], nums[j]));
                int newMax = Math.max(maxNum, Math.max(nums[i], nums[j]));
                lowScore = Math.min(lowScore, newMax - newMin);
            }
        }

        return lowScore;
    }
}