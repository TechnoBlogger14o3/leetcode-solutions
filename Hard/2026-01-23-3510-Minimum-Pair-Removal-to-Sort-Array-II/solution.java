class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        while (!isNonDecreasing(nums)) {
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < n - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    minIndex = i;
                }
            }

            nums[minIndex] = nums[minIndex] + nums[minIndex + 1];
            for (int i = minIndex + 1; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }
            n--;
            operations++;
        }

        return operations;
    }

    private boolean isNonDecreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}