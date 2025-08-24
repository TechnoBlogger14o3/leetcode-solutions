/**
 * @param {number[]} nums
 * @return {number}
 */
var longestSubarray = function(nums) {
    if (!nums || nums.length === 0) return 0;
    
    let left = 0, right = 0;
    let zeroCount = 0;
    let maxLength = 0;
    
    // Sliding window approach
    while (right < nums.length) {
        // If we encounter a 0, increment the zero count
        if (nums[right] === 0) {
            zeroCount++;
        }
        
        // If we have more than one 0, shrink the window from left
        while (zeroCount > 1) {
            if (nums[left] === 0) {
                zeroCount--;
            }
            left++;
        }
        
        // Update the maximum length
        // Note: we subtract 1 because we must delete one element
        maxLength = Math.max(maxLength, right - left + 1);
        
        right++;
    }
    
    // If the entire array is 1's, we must delete one element
    if (maxLength === nums.length && zeroCount === 0) {
        return maxLength - 1;
    }
    
    // Otherwise, return maxLength - 1 (since we must delete one element)
    return Math.max(0, maxLength - 1);
};
