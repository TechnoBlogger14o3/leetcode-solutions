/**
 * Time Complexity: O(n) - Each element pushed/popped once
 * Space Complexity: O(n) - Stack can hold all indices
 */
var dailyTemperatures = function(temperatures) {
    const n = temperatures.length;
    const result = new Array(n).fill(0);
    const stack = [];
    
    for (let i = 0; i < n; i++) {
        while (stack.length > 0 && temperatures[i] > temperatures[stack[stack.length - 1]]) {
            const index = stack.pop();
            result[index] = i - index;
        }
        stack.push(i);
    }
    
    return result;
};

// Alternative approach using ArrayDeque simulation
var dailyTemperaturesArrayDeque = function(temperatures) {
    const n = temperatures.length;
    const result = new Array(n).fill(0);
    const stack = [];
    
    for (let i = 0; i < n; i++) {
        while (stack.length > 0 && temperatures[i] > temperatures[stack[0]]) {
            const index = stack.shift();
            result[index] = i - index;
        }
        stack.unshift(i);
    }
    
    return result;
};

// Brute force approach
var dailyTemperaturesBruteForce = function(temperatures) {
    const n = temperatures.length;
    const result = new Array(n).fill(0);
    
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            if (temperatures[j] > temperatures[i]) {
                result[i] = j - i;
                break;
            }
        }
    }
    
    return result;
};

// More concise version
var dailyTemperaturesConcise = function(temperatures) {
    const result = new Array(temperatures.length).fill(0);
    const stack = [];
    
    for (let i = 0; i < temperatures.length; i++) {
        while (stack.length && temperatures[i] > temperatures[stack[stack.length - 1]]) {
            result[stack.pop()] = i - stack[stack.length - 1];
        }
        stack.push(i);
    }
    
    return result;
};

// Using Map for debugging
var dailyTemperaturesDebug = function(temperatures) {
    const result = new Array(temperatures.length).fill(0);
    const stack = [];
    
    for (let i = 0; i < temperatures.length; i++) {
        console.log(`Processing day ${i}, temperature ${temperatures[i]}`);
        
        while (stack.length > 0 && temperatures[i] > temperatures[stack[stack.length - 1]]) {
            const index = stack.pop();
            result[index] = i - index;
            console.log(`Day ${index} waits ${result[index]} days`);
        }
        
        stack.push(i);
        console.log(`Stack: [${stack.join(', ')}]`);
    }
    
    return result;
};
