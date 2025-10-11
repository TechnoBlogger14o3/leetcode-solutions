/**
 * Time Complexity: O(log n) - Binary search
 * Space Complexity: O(1) - Only uses constant extra space
 */
var search = function(nums, target) {
    let left = 0;
    let right = nums.length - 1;
    
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2);
        
        if (nums[mid] === target) {
            return mid;
        }
        
        // Check which half is sorted
        if (nums[left] <= nums[mid]) {
            // Left half is sorted
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            // Right half is sorted
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    
    return -1;
};

// Alternative approach using two binary searches
var searchTwoPass = function(nums, target) {
    const pivot = findPivot(nums);
    
    if (pivot === -1) {
        // No rotation, use standard binary search
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    if (nums[pivot] === target) {
        return pivot;
    }
    
    if (target >= nums[0]) {
        return binarySearch(nums, target, 0, pivot - 1);
    } else {
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
};

function findPivot(nums) {
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
    
    return left;
}

function binarySearch(nums, target, left, right) {
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2);
        
        if (nums[mid] === target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return -1;
}

// More concise version
var searchConcise = function(nums, target) {
    let left = 0, right = nums.length - 1;
    
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2);
        
        if (nums[mid] === target) return mid;
        
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        } else {
            if (target > nums[mid] && target <= nums[right]) left = mid + 1;
            else right = mid - 1;
        }
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
        }
        
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
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
        
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) return binarySearch(left, mid - 1);
            return binarySearch(mid + 1, right);
        } else {
            if (target > nums[mid] && target <= nums[right]) return binarySearch(mid + 1, right);
            return binarySearch(left, mid - 1);
        }
    };
    
    return binarySearch(0, nums.length - 1);
};
