var maxDepth = function(s) {
    let depth = 0;
    let maxDepth = 0;
    
    for (let char of s) {
        if (char === '(') {
            depth++;
            maxDepth = Math.max(maxDepth, depth);
        } else if (char === ')') {
            depth--;
        }
    }
    
    return maxDepth;
};