var smallestSubsequence = function(s) {
    const lastIndex = {};
    const seen = new Set();
    const stack = [];

    for (let i = 0; i < s.length; i++) {
        lastIndex[s[i]] = i;
    }

    for (let i = 0; i < s.length; i++) {
        if (seen.has(s[i])) continue;
        while (stack.length && s[i] < stack[stack.length - 1] && lastIndex[stack[stack.length - 1]] > i) {
            seen.delete(stack.pop());
        }
        stack.push(s[i]);
        seen.add(s[i]);
    }

    return stack.join('');
};