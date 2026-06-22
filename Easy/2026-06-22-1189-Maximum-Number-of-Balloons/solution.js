var maxNumberOfBalloons = function(text) {
    const count = {};
    for (const char of text) {
        count[char] = (count[char] || 0) + 1;
    }
    
    const b = (count['b'] || 0);
    const a = (count['a'] || 0);
    const l = Math.floor((count['l'] || 0) / 2);
    const o = Math.floor((count['o'] || 0) / 2);
    const n = (count['n'] || 0);
    
    return Math.min(b, a, l, o, n);
};