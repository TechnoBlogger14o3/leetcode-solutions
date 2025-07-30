// Solution for LeetCode Problem #2412: LongestSubarrayWithMaximumBitwiseAnd
// Date: 2025-07-30
// Difficulty: Medium
// Language: JavaScript

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var longestSubarray = function(nums, k) {
    let maxLength = 0;
    
    for (let i = 0; i < nums.length; i++) {
        let currentAnd = nums[i];
        if (currentAnd === k) {
            maxLength = Math.max(maxLength, 1);
        }
        
        for (let j = i + 1; j < nums.length; j++) {
            currentAnd &= nums[j];
            if (currentAnd === k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
    }
    
    return maxLength;
};
