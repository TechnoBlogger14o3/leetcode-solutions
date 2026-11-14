class Solution {
    public int minPositiveSumSubarray(int[] nums, int l, int r) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;
        
        for (int size = l; size <= r; size++) {
            for (int start = 0; start <= n - size; start++) {
                int sum = 0;
                for (int i = start; i < start + size; i++) {
                    sum += nums[i];
                }
                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }
        
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}