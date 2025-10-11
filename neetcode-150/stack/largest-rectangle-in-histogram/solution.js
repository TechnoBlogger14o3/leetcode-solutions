/**
 * Time Complexity: O(n) - Each bar pushed/popped once
 * Space Complexity: O(n) - Stack can hold all indices
 */
var largestRectangleArea = function(heights) {
    const stack = [];
    let maxArea = 0;
    
    for (let i = 0; i <= heights.length; i++) {
        const h = (i === heights.length) ? 0 : heights[i];
        
        while (stack.length > 0 && h < heights[stack[stack.length - 1]]) {
            const height = heights[stack.pop()];
            const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        
        stack.push(i);
    }
    
    return maxArea;
};

// Alternative approach using ArrayDeque simulation
var largestRectangleAreaArrayDeque = function(heights) {
    const stack = [];
    let maxArea = 0;
    
    for (let i = 0; i <= heights.length; i++) {
        const h = (i === heights.length) ? 0 : heights[i];
        
        while (stack.length > 0 && h < heights[stack[0]]) {
            const height = heights[stack.shift()];
            const width = stack.length === 0 ? i : i - stack[0] - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        
        stack.unshift(i);
    }
    
    return maxArea;
};

// Brute force approach
var largestRectangleAreaBruteForce = function(heights) {
    let maxArea = 0;
    
    for (let i = 0; i < heights.length; i++) {
        let minHeight = heights[i];
        
        for (let j = i; j < heights.length; j++) {
            minHeight = Math.min(minHeight, heights[j]);
            const area = minHeight * (j - i + 1);
            maxArea = Math.max(maxArea, area);
        }
    }
    
    return maxArea;
};

// More concise version
var largestRectangleAreaConcise = function(heights) {
    const stack = [];
    let maxArea = 0;
    
    for (let i = 0; i <= heights.length; i++) {
        const h = (i === heights.length) ? 0 : heights[i];
        
        while (stack.length && h < heights[stack[stack.length - 1]]) {
            const height = heights[stack.pop()];
            const width = stack.length ? i - stack[stack.length - 1] - 1 : i;
            maxArea = Math.max(maxArea, height * width);
        }
        
        if (i < heights.length) {
            stack.push(i);
        }
    }
    
    return maxArea;
};

// Using Map for debugging
var largestRectangleAreaDebug = function(heights) {
    const stack = [];
    let maxArea = 0;
    
    for (let i = 0; i <= heights.length; i++) {
        const h = (i === heights.length) ? 0 : heights[i];
        console.log(`Processing bar ${i}, height ${h}`);
        
        while (stack.length > 0 && h < heights[stack[stack.length - 1]]) {
            const height = heights[stack.pop()];
            const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1;
            const area = height * width;
            maxArea = Math.max(maxArea, area);
            console.log(`Bar ${i}: height=${height}, width=${width}, area=${area}, maxArea=${maxArea}`);
        }
        
        stack.push(i);
        console.log(`Stack: [${stack.join(', ')}]`);
    }
    
    return maxArea;
};
