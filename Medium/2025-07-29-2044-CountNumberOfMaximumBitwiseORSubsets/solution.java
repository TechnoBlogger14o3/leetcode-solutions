// Solution for LeetCode Problem #2044: Count Number of Maximum Bitwise OR Subsets
// Date: 2025-07-29
// Difficulty: Medium
// Language: Java

class Solution {
    private int maxOR = 0;
    private int maxSize = 0;
    private int count = 0;
    
    public int countMaxOrSubsets(int[] nums) {
        // Calculate the maximum possible OR value
        maxOR = 0;
        for (int num : nums) {
            maxOR |= num;
        }
        
        // Reset counters
        maxSize = 0;
        count = 0;
        
        // Use backtracking to find all subsets
        backtrack(nums, 0, 0, 0);
        
        return count;
    }
    
    private void backtrack(int[] nums, int index, int currentOR, int currentSize) {
        // If we've processed all elements
        if (index == nums.length) {
            // If this subset achieves the maximum OR
            if (currentOR == maxOR) {
                // If this is the first subset with max OR, or same size as current max
                if (currentSize > maxSize) {
                    maxSize = currentSize;
                    count = 1;
                } else if (currentSize == maxSize) {
                    count++;
                }
            }
            return;
        }
        
        // Include the current element
        backtrack(nums, index + 1, currentOR | nums[index], currentSize + 1);
        
        // Exclude the current element
        backtrack(nums, index + 1, currentOR, currentSize);
    }
}
