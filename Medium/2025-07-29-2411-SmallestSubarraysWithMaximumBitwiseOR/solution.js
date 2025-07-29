// Solution for LeetCode Problem #2411: Smallest Subarrays With Maximum Bitwise OR
// Date: 2025-07-29
// Difficulty: Medium
// Language: JavaScript

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var smallestSubarrays = function(nums) {
    const n = nums.length;
    const result = new Array(n);
    
    // For each starting position
    for (let i = 0; i < n; i++) {
        let currentOR = 0;
        let minLength = 1;
        
        // Calculate the maximum possible OR value starting from position i
        let maxOR = 0;
        for (let j = i; j < n; j++) {
            maxOR |= nums[j];
        }
        
        // Find the smallest subarray that achieves the maximum OR
        currentOR = 0;
        for (let j = i; j < n; j++) {
            currentOR |= nums[j];
            if (currentOR === maxOR) {
                minLength = j - i + 1;
                break;
            }
        }
        
        result[i] = minLength;
    }
    
    return result;
};
