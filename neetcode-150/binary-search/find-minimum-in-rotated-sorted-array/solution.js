/**
 * Time Complexity: O(log n) - Binary search
 * Space Complexity: O(1) - Only uses constant extra space
 */
var findMin = function(nums) {
    let left = 0;
    let right = nums.length - 1;
    
    while (left < right) {
        const mid = Math.floor(left + (right - left) / 2);
        
        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    
    return nums[left];
};

// Alternative approach using recursive binary search
var findMinRecursive = function(nums) {
    return findMinHelper(nums, 0, nums.length - 1);
};

function findMinHelper(nums, left, right) {
    if (left >= right) {
        return nums[left];
    }
    
    const mid = Math.floor(left + (right - left) / 2);
    
    if (nums[mid] > nums[right]) {
        return findMinHelper(nums, mid + 1, right);
    } else {
        return findMinHelper(nums, left, mid);
    }
}

// Alternative approach comparing with leftmost element
var findMinLeft = function(nums) {
    let left = 0;
    let right = nums.length - 1;
    
    while (left < right) {
        const mid = Math.floor(left + (right - left) / 2);
        
        if (nums[mid] < nums[left]) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    return nums[left];
};

// More concise version
var findMinConcise = function(nums) {
    let left = 0, right = nums.length - 1;
    
    while (left < right) {
        const mid = Math.floor(left + (right - left) / 2);
        if (nums[mid] > nums[right]) left = mid + 1;
        else right = mid;
    }
    
    return nums[left];
};

// Using bit manipulation for mid calculation
var findMinBitManipulation = function(nums) {
    let left = 0;
    let right = nums.length - 1;
    
    while (left < right) {
        const mid = (left + right) >>> 1; // Unsigned right shift
        
        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    
    return nums[left];
};

// Using arrow functions
var findMinArrow = function(nums) {
    const findMinHelper = (left, right) => {
        if (left >= right) return nums[left];
        
        const mid = Math.floor(left + (right - left) / 2);
        if (nums[mid] > nums[right]) return findMinHelper(mid + 1, right);
        return findMinHelper(left, mid);
    };
    
    return findMinHelper(0, nums.length - 1);
};
