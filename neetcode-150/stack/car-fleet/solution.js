/**
 * Time Complexity: O(n log n) - Sorting
 * Space Complexity: O(n) - Stack and sorting
 */
var carFleet = function(target, position, speed) {
    const n = position.length;
    const cars = [];
    
    // Create pairs of (position, time to reach target)
    for (let i = 0; i < n; i++) {
        cars.push([position[i], (target - position[i]) / speed[i]]);
    }
    
    // Sort by position (closest to target first)
    cars.sort((a, b) => a[0] - b[0]);
    
    const stack = [];
    
    // Process cars from right to left
    for (let i = n - 1; i >= 0; i--) {
        const time = cars[i][1];
        
        // If stack is empty or current car reaches target after stack top
        if (stack.length === 0 || time > stack[stack.length - 1]) {
            stack.push(time);
        }
    }
    
    return stack.length;
};

// Alternative approach using Map
var carFleetMap = function(target, position, speed) {
    const n = position.length;
    const cars = new Map();
    
    for (let i = 0; i < n; i++) {
        cars.set(position[i], (target - position[i]) / speed[i]);
    }
    
    // Sort positions
    const sortedPositions = Array.from(cars.keys()).sort((a, b) => a - b);
    
    const stack = [];
    
    for (let i = sortedPositions.length - 1; i >= 0; i--) {
        const time = cars.get(sortedPositions[i]);
        
        if (stack.length === 0 || time > stack[stack.length - 1]) {
            stack.push(time);
        }
    }
    
    return stack.length;
};

// More concise version
var carFleetConcise = function(target, position, speed) {
    const cars = position.map((pos, i) => [pos, (target - pos) / speed[i]]);
    cars.sort((a, b) => a[0] - b[0]);
    
    const stack = [];
    for (let i = cars.length - 1; i >= 0; i--) {
        const time = cars[i][1];
        if (!stack.length || time > stack[stack.length - 1]) {
            stack.push(time);
        }
    }
    
    return stack.length;
};

// Using object for sorting
var carFleetObject = function(target, position, speed) {
    const cars = position.map((pos, i) => ({
        position: pos,
        time: (target - pos) / speed[i]
    }));
    
    cars.sort((a, b) => a.position - b.position);
    
    const stack = [];
    for (let i = cars.length - 1; i >= 0; i--) {
        const time = cars[i].time;
        if (!stack.length || time > stack[stack.length - 1]) {
            stack.push(time);
        }
    }
    
    return stack.length;
};
