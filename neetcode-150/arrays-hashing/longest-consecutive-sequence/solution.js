/**
 * Time Complexity: O(n) - Each number visited at most twice
 * Space Complexity: O(n) - For Set
 */
var longestConsecutive = function(nums) {
    if (nums.length === 0) {
        return 0;
    }
    
    const numSet = new Set(nums);
    let maxLength = 0;
    
    for (const num of nums) {
        // Check if this is the start of a sequence
        if (!numSet.has(num - 1)) {
            let currentLength = 1;
            let currentNum = num;
            
            // Count consecutive numbers
            while (numSet.has(currentNum + 1)) {
                currentLength++;
                currentNum++;
            }
            
            maxLength = Math.max(maxLength, currentLength);
        }
    }
    
    return maxLength;
};

// Alternative approach using sorting
var longestConsecutiveSorting = function(nums) {
    if (nums.length === 0) {
        return 0;
    }
    
    nums.sort((a, b) => a - b);
    
    let maxLength = 1;
    let currentLength = 1;
    
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === nums[i - 1]) {
            // Skip duplicates
            continue;
        } else if (nums[i] === nums[i - 1] + 1) {
            // Consecutive
            currentLength++;
        } else {
            // Not consecutive, reset
            maxLength = Math.max(maxLength, currentLength);
            currentLength = 1;
        }
    }
    
    return Math.max(maxLength, currentLength);
};

// More concise version
var longestConsecutiveConcise = function(nums) {
    const numSet = new Set(nums);
    let maxLength = 0;
    
    for (const num of numSet) {
        if (!numSet.has(num - 1)) {
            let length = 1;
            while (numSet.has(num + length)) {
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }
    }
    
    return maxLength;
};
