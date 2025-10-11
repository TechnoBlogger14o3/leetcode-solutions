/**
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(1) - Only using two pointers
 */
var maxArea = function(height) {
    let left = 0;
    let right = height.length - 1;
    let maxArea = 0;
    
    while (left < right) {
        // Calculate area
        const area = Math.min(height[left], height[right]) * (right - left);
        maxArea = Math.max(maxArea, area);
        
        // Move pointer with smaller height
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    
    return maxArea;
};

// Alternative approach using brute force
var maxAreaBruteForce = function(height) {
    let maxArea = 0;
    
    for (let i = 0; i < height.length; i++) {
        for (let j = i + 1; j < height.length; j++) {
            const area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
        }
    }
    
    return maxArea;
};

// More concise version
var maxAreaConcise = function(height) {
    let maxArea = 0;
    let left = 0, right = height.length - 1;
    
    while (left < right) {
        maxArea = Math.max(maxArea, 
            Math.min(height[left], height[right]) * (right - left));
        
        if (height[left] < height[right]) left++;
        else right--;
    }
    
    return maxArea;
};
