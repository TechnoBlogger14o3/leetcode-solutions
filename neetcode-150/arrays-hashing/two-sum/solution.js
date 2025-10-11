/**
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(n) - Object can store up to n elements
 */
var twoSum = function(nums, target) {
    const numToIndex = {};
    
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        
        if (complement in numToIndex) {
            return [numToIndex[complement], i];
        }
        
        numToIndex[nums[i]] = i;
    }
    
    return []; // Should not reach here
};

// Brute force approach (not recommended for large inputs)
var twoSumBruteForce = function(nums, target) {
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] === target) {
                return [i, j];
            }
        }
    }
    return [];
};

// Two-pass approach
var twoSumTwoPass = function(nums, target) {
    const numToIndex = {};
    
    // First pass: build the map
    for (let i = 0; i < nums.length; i++) {
        numToIndex[nums[i]] = i;
    }
    
    // Second pass: find the complement
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if (complement in numToIndex && numToIndex[complement] !== i) {
            return [i, numToIndex[complement]];
        }
    }
    
    return [];
};
