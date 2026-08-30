class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) minIndex = i;
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        int left = Math.min(minIndex, maxIndex) + 1;
        int right = n - Math.max(minIndex, maxIndex);
        int bothEnds = minIndex + 1 + (n - maxIndex);
        int bothEndsReverse = maxIndex + 1 + (n - minIndex);

        return Math.min(Math.min(left + right, bothEnds), bothEndsReverse);
    }
}