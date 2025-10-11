/**
 * Time Complexity: O(n) - Single pass through string
 * Space Complexity: O(n) - Stack can hold up to n characters
 */
var isValid = function(s) {
    const stack = [];
    
    for (const c of s) {
        if (c === '(' || c === '{' || c === '[') {
            stack.push(c);
        } else {
            if (stack.length === 0) return false;
            
            const top = stack.pop();
            if ((c === ')' && top !== '(') ||
                (c === '}' && top !== '{') ||
                (c === ']' && top !== '[')) {
                return false;
            }
        }
    }
    
    return stack.length === 0;
};

// Alternative approach using Map
var isValidMap = function(s) {
    const stack = [];
    const map = new Map([
        [')', '('],
        ['}', '{'],
        [']', '[']
    ]);
    
    for (const c of s) {
        if (map.has(c)) {
            if (stack.length === 0 || stack.pop() !== map.get(c)) {
                return false;
            }
        } else {
            stack.push(c);
        }
    }
    
    return stack.length === 0;
};

// More concise version
var isValidConcise = function(s) {
    const stack = [];
    for (const c of s) {
        if (c === '(') stack.push(')');
        else if (c === '{') stack.push('}');
        else if (c === '[') stack.push(']');
        else if (stack.length === 0 || stack.pop() !== c) return false;
    }
    return stack.length === 0;
};

// Using object for mapping
var isValidObject = function(s) {
    const stack = [];
    const pairs = { ')': '(', '}': '{', ']': '[' };
    
    for (const c of s) {
        if (pairs[c]) {
            if (stack.length === 0 || stack.pop() !== pairs[c]) {
                return false;
            }
        } else {
            stack.push(c);
        }
    }
    
    return stack.length === 0;
};
