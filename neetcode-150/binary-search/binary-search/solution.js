/**
 * Time Complexity: O(log n) - Halves search space each iteration
 * Space Complexity: O(1) - Only uses constant extra space
 */
var search = function(nums, target) {
    let left = 0;
    let right = nums.length - 1;
    
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2); // Prevent overflow
        
        if (nums[mid] === target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return -1;
};

// Alternative approach using recursive binary search
var searchRecursive = function(nums, target) {
    return binarySearch(nums, target, 0, nums.length - 1);
};

function binarySearch(nums, target, left, right) {
    if (left > right) {
        return -1;
    }
    
    const mid = Math.floor(left + (right - left) / 2);
    
    if (nums[mid] === target) {
        return mid;
    } else if (nums[mid] < target) {
        return binarySearch(nums, target, mid + 1, right);
    } else {
        return binarySearch(nums, target, left, mid - 1);
    }
}

// Alternative approach using built-in methods
var searchBuiltIn = function(nums, target) {
    const index = nums.indexOf(target);
    return index;
};

// More concise version
var searchConcise = function(nums, target) {
    let left = 0, right = nums.length - 1;
    
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2);
        if (nums[mid] === target) return mid;
        if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    
    return -1;
};

// Using bit manipulation for mid calculation
var searchBitManipulation = function(nums, target) {
    let left = 0;
    let right = nums.length - 1;
    
    while (left <= right) {
        const mid = (left + right) >>> 1; // Unsigned right shift
        
        if (nums[mid] === target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return -1;
};

// Using arrow functions
var searchArrow = function(nums, target) {
    const binarySearch = (left, right) => {
        if (left > right) return -1;
        
        const mid = Math.floor(left + (right - left) / 2);
        if (nums[mid] === target) return mid;
        if (nums[mid] < target) return binarySearch(mid + 1, right);
        return binarySearch(left, mid - 1);
    };
    
    return binarySearch(0, nums.length - 1);
};
