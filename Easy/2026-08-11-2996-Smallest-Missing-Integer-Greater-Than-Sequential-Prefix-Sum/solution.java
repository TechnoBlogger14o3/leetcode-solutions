class Solution {
    public int smallestMissingGreaterThanPrefixSum(int[] nums) {
        int maxLength = 0;
        int currentLength = 1;
        int prefixSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                currentLength++;
                prefixSum += nums[i];
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
                prefixSum = nums[i];
            }
        }
        maxLength = Math.max(maxLength, currentLength);
        
        int longestPrefixSum = 0;
        for (int i = 0; i < maxLength; i++) {
            longestPrefixSum += nums[i];
        }
        
        boolean[] present = new boolean[51];
        for (int num : nums) {
            present[num] = true;
        }
        
        for (int x = longestPrefixSum; x <= 50; x++) {
            if (!present[x]) {
                return x;
            }
        }
        
        return 51; // In case all numbers from longestPrefixSum to 50 are present
    }
}