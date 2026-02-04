class Solution {
    public long maximumTrionicSubarraySum(int[] nums) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE;

        for (int p = 1; p < n - 2; p++) {
            long leftSum = 0, rightSum = 0;
            int l = p - 1, r = p + 1;

            // Find left increasing subarray
            while (l >= 0 && nums[l] < nums[l + 1]) {
                leftSum += nums[l];
                l--;
            }
            leftSum += nums[l + 1]; // Include nums[l + 1] (the last increasing element)

            // Find right increasing subarray
            while (r < n && nums[r] > nums[r - 1]) {
                rightSum += nums[r];
                r++;
            }
            rightSum += nums[r - 1]; // Include nums[r - 1] (the last increasing element)

            // Find the middle decreasing subarray
            long middleSum = 0;
            int q = p;
            while (q < n - 1 && nums[q] > nums[q + 1]) {
                middleSum += nums[q];
                q++;
            }
            middleSum += nums[q]; // Include nums[q] (the last decreasing element)

            // Calculate total sum for this trionic subarray
            long totalSum = leftSum + middleSum + rightSum;
            maxSum = Math.max(maxSum, totalSum);
        }

        return maxSum;
    }
}