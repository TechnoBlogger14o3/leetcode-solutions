/**
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n) - Two stacks
 */
var MinStack = function() {
    this.stack = [];
    this.minStack = [];
};

MinStack.prototype.push = function(val) {
    this.stack.push(val);
    if (this.minStack.length === 0 || val <= this.minStack[this.minStack.length - 1]) {
        this.minStack.push(val);
    }
};

MinStack.prototype.pop = function() {
    if (this.stack.length === 0) return;
    
    const val = this.stack.pop();
    if (val === this.minStack[this.minStack.length - 1]) {
        this.minStack.pop();
    }
};

MinStack.prototype.top = function() {
    return this.stack[this.stack.length - 1];
};

MinStack.prototype.getMin = function() {
    return this.minStack[this.minStack.length - 1];
};

// Alternative approach using single stack with pairs
var MinStackSingle = function() {
    this.stack = [];
};

MinStackSingle.prototype.push = function(val) {
    if (this.stack.length === 0) {
        this.stack.push([val, val]);
    } else {
        const min = Math.min(val, this.stack[this.stack.length - 1][1]);
        this.stack.push([val, min]);
    }
};

MinStackSingle.prototype.pop = function() {
    this.stack.pop();
};

MinStackSingle.prototype.top = function() {
    return this.stack[this.stack.length - 1][0];
};

MinStackSingle.prototype.getMin = function() {
    return this.stack[this.stack.length - 1][1];
};

// ES6 Class syntax
class MinStackES6 {
    constructor() {
        this.stack = [];
        this.minStack = [];
    }
    
    push(val) {
        this.stack.push(val);
        if (this.minStack.length === 0 || val <= this.minStack[this.minStack.length - 1]) {
            this.minStack.push(val);
        }
    }
    
    pop() {
        if (this.stack.length === 0) return;
        
        const val = this.stack.pop();
        if (val === this.minStack[this.minStack.length - 1]) {
            this.minStack.pop();
        }
    }
    
    top() {
        return this.stack[this.stack.length - 1];
    }
    
    getMin() {
        return this.minStack[this.minStack.length - 1];
    }
}

// More concise version
var MinStackConcise = function() {
    this.stack = [];
    this.minStack = [];
};

MinStackConcise.prototype.push = function(val) {
    this.stack.push(val);
    if (!this.minStack.length || val <= this.minStack[this.minStack.length - 1]) {
        this.minStack.push(val);
    }
};

MinStackConcise.prototype.pop = function() {
    if (this.stack.pop() === this.minStack[this.minStack.length - 1]) {
        this.minStack.pop();
    }
};

MinStackConcise.prototype.top = function() {
    return this.stack[this.stack.length - 1];
};

MinStackConcise.prototype.getMin = function() {
    return this.minStack[this.minStack.length - 1];
};
