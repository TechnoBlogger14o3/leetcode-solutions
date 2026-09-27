var reverseParentheses = function(s) {
    const stack = [];
    let current = '';

    for (const char of s) {
        if (char === '(') {
            stack.push(current);
            current = '';
        } else if (char === ')') {
            current = stack.pop() + current.split('').reverse().join('');
        } else {
            current += char;
        }
    }

    return current;
};