/**
 * Time Complexity: O(n) - Each element added/removed once
 * Space Complexity: O(k) - Deque size at most k
 */
var maxSlidingWindow = function(nums, k) {
    const n = nums.length;
    const result = new Array(n - k + 1);
    const deque = [];
    
    for (let i = 0; i < n; i++) {
        // Remove indices outside current window
        while (deque.length > 0 && deque[0] <= i - k) {
            deque.shift();
        }
        
        // Remove indices with smaller values
        while (deque.length > 0 && nums[deque[deque.length - 1]] <= nums[i]) {
            deque.pop();
        }
        
        // Add current index
        deque.push(i);
        
        // Add maximum to result when window size is k
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque[0]];
        }
    }
    
    return result;
};

// Alternative approach using Priority Queue (simulated with sorting)
var maxSlidingWindowPriorityQueue = function(nums, k) {
    const n = nums.length;
    const result = new Array(n - k + 1);
    
    // Initialize first window
    const window = nums.slice(0, k).sort((a, b) => b - a);
    result[0] = window[0];
    
    // Slide window
    for (let i = k; i < n; i++) {
        // Remove leftmost element
        const leftElement = nums[i - k];
        const index = window.indexOf(leftElement);
        window.splice(index, 1);
        
        // Add rightmost element
        window.push(nums[i]);
        window.sort((a, b) => b - a);
        
        result[i - k + 1] = window[0];
    }
    
    return result;
};

// More concise version
var maxSlidingWindowConcise = function(nums, k) {
    const result = [];
    const deque = [];
    
    for (let i = 0; i < nums.length; i++) {
        while (deque.length > 0 && deque[0] <= i - k) {
            deque.shift();
        }
        while (deque.length > 0 && nums[deque[deque.length - 1]] <= nums[i]) {
            deque.pop();
        }
        deque.push(i);
        if (i >= k - 1) {
            result.push(nums[deque[0]]);
        }
    }
    
    return result;
};

// Using Map to simulate priority queue
var maxSlidingWindowMap = function(nums, k) {
    const result = [];
    const window = new Map();
    
    // Initialize first window
    for (let i = 0; i < k; i++) {
        window.set(nums[i], (window.get(nums[i]) || 0) + 1);
    }
    result.push(Math.max(...window.keys()));
    
    // Slide window
    for (let i = k; i < nums.length; i++) {
        // Remove leftmost element
        const leftElement = nums[i - k];
        window.set(leftElement, window.get(leftElement) - 1);
        if (window.get(leftElement) === 0) {
            window.delete(leftElement);
        }
        
        // Add rightmost element
        window.set(nums[i], (window.get(nums[i]) || 0) + 1);
        
        result.push(Math.max(...window.keys()));
    }
    
    return result;
};
