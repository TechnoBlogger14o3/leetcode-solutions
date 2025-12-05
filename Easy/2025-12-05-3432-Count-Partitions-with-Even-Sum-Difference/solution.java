class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            rightSum += num;
        }

        int count = 0;
        leftSum = 0;

        // Iterate through the array to find valid partitions
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];

            // Check if the difference is even
            if ((leftSum - rightSum) % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}