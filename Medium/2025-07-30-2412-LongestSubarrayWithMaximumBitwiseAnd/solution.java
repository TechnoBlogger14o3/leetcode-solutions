// Solution for LeetCode Problem #2412: LongestSubarrayWithMaximumBitwiseAnd
// Date: 2025-07-30
// Difficulty: Medium
// Language: Java

class Solution {
    public int longestSubarray(int[] nums, int k) {
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int currentAnd = nums[i];
            if (currentAnd == k) {
                maxLength = Math.max(maxLength, 1);
            }
            
            for (int j = i + 1; j < nums.length; j++) {
                currentAnd &= nums[j];
                if (currentAnd == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        
        return maxLength;
    }
}
