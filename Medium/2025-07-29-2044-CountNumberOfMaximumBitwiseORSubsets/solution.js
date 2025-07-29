// Solution for LeetCode Problem #2044: Count Number of Maximum Bitwise OR Subsets
// Date: 2025-07-29
// Difficulty: Medium
// Language: JavaScript

/**
 * @param {number[]} nums
 * @return {number}
 */
var countMaxOrSubsets = function(nums) {
    // Calculate the maximum possible OR value
    let maxOR = 0;
    for (let num of nums) {
        maxOR |= num;
    }
    
    let maxSize = 0;
    let count = 0;
    
    // Use backtracking to find all subsets
    function backtrack(index, currentOR, currentSize) {
        // If we've processed all elements
        if (index === nums.length) {
            // If this subset achieves the maximum OR
            if (currentOR === maxOR) {
                // If this is the first subset with max OR, or same size as current max
                if (currentSize > maxSize) {
                    maxSize = currentSize;
                    count = 1;
                } else if (currentSize === maxSize) {
                    count++;
                }
            }
            return;
        }
        
        // Include the current element
        backtrack(index + 1, currentOR | nums[index], currentSize + 1);
        
        // Exclude the current element
        backtrack(index + 1, currentOR, currentSize);
    }
    
    backtrack(0, 0, 0);
    return count;
};
