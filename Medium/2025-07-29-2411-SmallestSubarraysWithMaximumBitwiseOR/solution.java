// Solution for LeetCode Problem #2411: Smallest Subarrays With Maximum Bitwise OR
// Date: 2025-07-29
// Difficulty: Medium
// Language: Java

class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // For each starting position
        for (int i = 0; i < n; i++) {
            int currentOR = 0;
            int minLength = 1;
            
            // Calculate the maximum possible OR value starting from position i
            int maxOR = 0;
            for (int j = i; j < n; j++) {
                maxOR |= nums[j];
            }
            
            // Find the smallest subarray that achieves the maximum OR
            currentOR = 0;
            for (int j = i; j < n; j++) {
                currentOR |= nums[j];
                if (currentOR == maxOR) {
                    minLength = j - i + 1;
                    break;
                }
            }
            
            result[i] = minLength;
        }
        
        return result;
    }
}
