/**
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(1) - Only using two pointers
 */
var twoSum = function(numbers, target) {
    let left = 0;
    let right = numbers.length - 1;
    
    while (left < right) {
        const sum = numbers[left] + numbers[right];
        
        if (sum === target) {
            return [left + 1, right + 1];
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    
    return []; // Should not reach here
};

// Alternative approach using binary search
var twoSumBinarySearch = function(numbers, target) {
    for (let i = 0; i < numbers.length; i++) {
        const complement = target - numbers[i];
        let left = i + 1;
        let right = numbers.length - 1;
        
        while (left <= right) {
            const mid = Math.floor((left + right) / 2);
            if (numbers[mid] === complement) {
                return [i + 1, mid + 1];
            } else if (numbers[mid] < complement) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    
    return [];
};

// Using Map (not optimal for sorted array)
var twoSumMap = function(numbers, target) {
    const numToIndex = new Map();
    
    for (let i = 0; i < numbers.length; i++) {
        const complement = target - numbers[i];
        
        if (numToIndex.has(complement)) {
            return [numToIndex.get(complement) + 1, i + 1];
        }
        
        numToIndex.set(numbers[i], i);
    }
    
    return [];
};
