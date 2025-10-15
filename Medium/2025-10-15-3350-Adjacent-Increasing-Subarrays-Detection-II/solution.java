class Solution {
    public int maxLengthBetweenIncreasingSubarrays(int[] nums) {
        int n = nums.length;
        int maxK = 0;
        
        // Array to store lengths of increasing subarrays
        int[] lengths = new int[n];
        
        // Calculate lengths of strictly increasing subarrays
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                lengths[i] = lengths[i - 1] + 1;
            }
        }
        
        // Find the maximum k for adjacent increasing subarrays
        for (int i = 1; i < n; i++) {
            if (lengths[i] > 0 && lengths[i - 1] > 0) {
                maxK = Math.max(maxK, Math.min(lengths[i], lengths[i - 1]) + 1);
            }
        }
        
        return maxK;
    }
}