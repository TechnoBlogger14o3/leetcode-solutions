/**
 * Time Complexity: O(n) - Single pass through tokens
 * Space Complexity: O(n) - Stack can hold all operands
 */
var evalRPN = function(tokens) {
    const stack = [];
    
    for (const token of tokens) {
        if (isOperator(token)) {
            const b = stack.pop();
            const a = stack.pop();
            const result = performOperation(a, b, token);
            stack.push(result);
        } else {
            stack.push(parseInt(token));
        }
    }
    
    return stack.pop();
};

function isOperator(token) {
    return ['+', '-', '*', '/'].includes(token);
}

function performOperation(a, b, operator) {
    switch (operator) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return Math.trunc(a / b);
        default: return 0;
    }
}

// Alternative approach using Map
var evalRPNMap = function(tokens) {
    const stack = [];
    const operations = new Map([
        ['+', (a, b) => a + b],
        ['-', (a, b) => a - b],
        ['*', (a, b) => a * b],
        ['/', (a, b) => Math.trunc(a / b)]
    ]);
    
    for (const token of tokens) {
        if (operations.has(token)) {
            const b = stack.pop();
            const a = stack.pop();
            stack.push(operations.get(token)(a, b));
        } else {
            stack.push(parseInt(token));
        }
    }
    
    return stack.pop();
};

// More concise version
var evalRPNConcise = function(tokens) {
    const stack = [];
    
    for (const token of tokens) {
        if (token === '+') {
            stack.push(stack.pop() + stack.pop());
        } else if (token === '-') {
            const b = stack.pop();
            const a = stack.pop();
            stack.push(a - b);
        } else if (token === '*') {
            stack.push(stack.pop() * stack.pop());
        } else if (token === '/') {
            const b = stack.pop();
            const a = stack.pop();
            stack.push(Math.trunc(a / b));
        } else {
            stack.push(parseInt(token));
        }
    }
    
    return stack.pop();
};

// Using object for operations
var evalRPNObject = function(tokens) {
    const stack = [];
    const ops = {
        '+': (a, b) => a + b,
        '-': (a, b) => a - b,
        '*': (a, b) => a * b,
        '/': (a, b) => Math.trunc(a / b)
    };
    
    for (const token of tokens) {
        if (ops[token]) {
            const b = stack.pop();
            const a = stack.pop();
            stack.push(ops[token](a, b));
        } else {
            stack.push(parseInt(token));
        }
    }
    
    return stack.pop();
};
