/**
 * Time Complexity: O(n) - Two passes through the array
 * Space Complexity: O(1) - Excluding the output array
 */
var productExceptSelf = function(nums) {
    const n = nums.length;
    const result = new Array(n);
    
    // First pass: calculate left products
    result[0] = 1;
    for (let i = 1; i < n; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }
    
    // Second pass: calculate right products and multiply
    let rightProduct = 1;
    for (let i = n - 1; i >= 0; i--) {
        result[i] *= rightProduct;
        rightProduct *= nums[i];
    }
    
    return result;
};

// Alternative approach using two arrays
var productExceptSelfTwoArrays = function(nums) {
    const n = nums.length;
    const leftProducts = new Array(n);
    const rightProducts = new Array(n);
    const result = new Array(n);
    
    // Calculate left products
    leftProducts[0] = 1;
    for (let i = 1; i < n; i++) {
        leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
    }
    
    // Calculate right products
    rightProducts[n - 1] = 1;
    for (let i = n - 2; i >= 0; i--) {
        rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
    }
    
    // Multiply left and right products
    for (let i = 0; i < n; i++) {
        result[i] = leftProducts[i] * rightProducts[i];
    }
    
    return result;
};

// More concise version
var productExceptSelfConcise = function(nums) {
    const result = [1];
    
    // Calculate left products
    for (let i = 1; i < nums.length; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }
    
    // Calculate right products and multiply
    let rightProduct = 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        result[i] *= rightProduct;
        rightProduct *= nums[i];
    }
    
    return result;
};
