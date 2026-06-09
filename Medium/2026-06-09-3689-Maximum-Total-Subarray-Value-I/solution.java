class Solution {
    public long maximumTotalValue(int[] nums, int k) {
        int n = nums.length;
        long maxValue = 0;
        
        // Calculate the max and min for the entire array
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }
        
        // The value of the whole array
        long totalValue = maxNum - minNum;
        
        // The maximum total value is k times the value of the whole array
        maxValue = totalValue * k;
        
        return maxValue;
    }
}