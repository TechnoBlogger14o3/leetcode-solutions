/**
 * Time Complexity: O(4^n / √n) - Catalan number
 * Space Complexity: O(n) - Recursion depth
 */
var generateParenthesis = function(n) {
    const result = [];
    backtrack(result, "", 0, 0, n);
    return result;
};

function backtrack(result, current, open, close, n) {
    if (open === n && close === n) {
        result.push(current);
        return;
    }
    
    if (open < n) {
        backtrack(result, current + "(", open + 1, close, n);
    }
    
    if (close < open) {
        backtrack(result, current + ")", open, close + 1, n);
    }
}

// Alternative approach using iterative method
var generateParenthesisIterative = function(n) {
    const result = [];
    const queue = [""];
    
    while (queue.length > 0) {
        const current = queue.shift();
        const open = (current.match(/\(/g) || []).length;
        const close = (current.match(/\)/g) || []).length;
        
        if (open === n && close === n) {
            result.push(current);
        } else {
            if (open < n) {
                queue.push(current + "(");
            }
            if (close < open) {
                queue.push(current + ")");
            }
        }
    }
    
    return result;
};

// More concise version
var generateParenthesisConcise = function(n) {
    const result = [];
    
    function generate(s, open, close) {
        if (s.length === 2 * n) {
            result.push(s);
            return;
        }
        
        if (open < n) generate(s + "(", open + 1, close);
        if (close < open) generate(s + ")", open, close + 1);
    }
    
    generate("", 0, 0);
    return result;
};

// Using arrow functions
var generateParenthesisArrow = function(n) {
    const result = [];
    
    const generate = (s, open, close) => {
        if (s.length === 2 * n) {
            result.push(s);
            return;
        }
        
        if (open < n) generate(s + "(", open + 1, close);
        if (close < open) generate(s + ")", open, close + 1);
    };
    
    generate("", 0, 0);
    return result;
};
